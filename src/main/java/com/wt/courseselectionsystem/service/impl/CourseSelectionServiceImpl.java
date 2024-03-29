package com.wt.courseselectionsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.wt.courseselectionsystem.common.ResultUtils;
import com.wt.courseselectionsystem.common.SystemUtils;
import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.dao.CoursePlanDao;
import com.wt.courseselectionsystem.dao.CourseSelectionDao;
import com.wt.courseselectionsystem.model.dao.basebean.CourseSelection;
import com.wt.courseselectionsystem.model.dao.exbean.CourseInfoForStudent;
import com.wt.courseselectionsystem.model.dao.exbean.CoursePlanInfo;
import com.wt.courseselectionsystem.model.dao.exbean.CourseSelectionSituationInfo;
import com.wt.courseselectionsystem.model.dao.exbean.CreditInfo;
import com.wt.courseselectionsystem.model.vo.request.course.select.CourseSelectionSituationQuery;
import com.wt.courseselectionsystem.model.vo.request.course.select.CreditsSummaryQuery;
import com.wt.courseselectionsystem.model.vo.response.course.select.*;
import com.wt.courseselectionsystem.service.CourseSelectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.wt.courseselectionsystem.common.constant.CourseSelectionConstant.CREDIT_STANDARD;

/**
 * @author lixin
 */
@Service
@Slf4j
public class CourseSelectionServiceImpl implements CourseSelectionService {

    private final CourseSelectionDao courseSelectionDao;
    private final CoursePlanDao coursePlanDao;

    private final Cache<String, Integer> quotaCache = CacheBuilder.newBuilder()
            .maximumSize(100L)
            .expireAfterAccess(1, TimeUnit.MINUTES)
            .build();

    private final Cache<String, AtomicInteger> usedQuotaCache = CacheBuilder.newBuilder()
            .maximumSize(100L)
            .expireAfterAccess(1, TimeUnit.MINUTES)
            .build();

    private final Cache<String, Lock> lockCache = CacheBuilder.newBuilder()
            .maximumSize(100L)
            .expireAfterAccess(5, TimeUnit.MINUTES)
            .build();

    public CourseSelectionServiceImpl(CourseSelectionDao courseSelectionDao, CoursePlanDao coursePlanDao) {
        this.courseSelectionDao = courseSelectionDao;
        this.coursePlanDao = coursePlanDao;
    }

    @Override
    public NoDataResult selectCourse(String studentNo, String coursePlanNo) {
        Integer sumCredit = Optional.ofNullable(courseSelectionDao.selectSumCredit(studentNo)).orElse(0);
        if (CREDIT_STANDARD.compareTo(sumCredit) <= 0) {
            return ResultUtils.fail("选课失败：学分已修满");
        }
        if (courseSelectionDao.countByStudentNoAndCoursePlanNo(studentNo, coursePlanNo) != 0) {
            return ResultUtils.fail("选课失败：重复选课");
        }
        // 课程名额
        Integer quota;
        try {
            quota = quotaCache.get(coursePlanNo,
                    () -> Optional.ofNullable(coursePlanDao.selectInfoByCoursePlanNo(coursePlanNo))
                            .map(CoursePlanInfo::getQuota)
                            .orElseThrow(() -> new RuntimeException("排课不存在")));
            Lock lock = lockCache.get(coursePlanNo, ReentrantLock::new);
            lock.lock();
            try {
                usedQuotaCache.get(coursePlanNo,
                        () -> new AtomicInteger(courseSelectionDao.countByCoursePlanNo(coursePlanNo)));
            } finally {
                lock.unlock();
            }
        } catch (ExecutionException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
        // 已使用名额
        AtomicInteger usedQuota = Optional.ofNullable(usedQuotaCache.getIfPresent(coursePlanNo))
                .orElseThrow(() -> new RuntimeException("获取缓存失败"));
        if (quota.compareTo(usedQuota.getAndIncrement()) <= 0) {
            // 满员判断
            return ResultUtils.fail("选课失败：课程人数已满");
        }

        CourseSelection courseSelection = new CourseSelection();
        courseSelection.setStudentNo(studentNo);
        courseSelection.setCoursePlanNo(coursePlanNo);
        courseSelection.setGmtCreate(LocalDateTime.now());
        return courseSelectionDao.insertCourseSelection(courseSelection) == 1 ?
                ResultUtils.success("选课成功") :
                ResultUtils.fail("选课失败");
    }

    @Override
    public DataResult<CreditsSummaryListVo> summary(CreditsSummaryQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<CreditInfo> list = courseSelectionDao.selectCreditsSummary(query);
        PageInfo<CreditInfo> info = new PageInfo<>(list);
        CreditsSummaryListVo result = new CreditsSummaryListVo();
        result.setList(SystemUtils.easyCopy(list, CreditsSummaryInfo.class));
        SystemUtils.configPageInfo(result, info);
        return ResultUtils.success(result);
    }

    @Override
    public DataResult<CourseSelectionSituationListVo> infoList(CourseSelectionSituationQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<CourseSelectionSituationInfo> coursePlans = courseSelectionDao.selectCourseSelections(query);
        PageInfo<CourseSelectionSituationInfo> info = new PageInfo<>(coursePlans);
        CourseSelectionSituationListVo situations = new CourseSelectionSituationListVo();
        situations.setList(SystemUtils.easyCopy(coursePlans, CourseSelectionSituationVo.class));
        SystemUtils.configPageInfo(situations, info);
        return ResultUtils.success(situations);
    }

    @Override
    public NoDataResult cancel(String coursePlanNo, String studentNo) {
        int row = courseSelectionDao.deleteByCoursePlanNoAndStudentNo(coursePlanNo, studentNo);
        return row == 1 ? ResultUtils.success("操作成功") : ResultUtils.fail("操作失败");
    }

    @Override
    public DataResult<StudentCourseSelectionList> list(String studentNo) {
        List<CourseInfoForStudent> list = courseSelectionDao.selectCoursePlanInfoByStudentNO(studentNo);
        StudentCourseSelectionList result = new StudentCourseSelectionList();
        result.setList(SystemUtils.easyCopy(list, CourseSelectionInfoForStudentVo.class));
        return ResultUtils.success(result);
    }
}
