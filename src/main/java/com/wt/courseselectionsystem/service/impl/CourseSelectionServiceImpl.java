package com.wt.courseselectionsystem.service.impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.wt.courseselectionsystem.common.ResultUtils;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.dao.CoursePlanDao;
import com.wt.courseselectionsystem.dao.CourseSelectionDao;
import com.wt.courseselectionsystem.model.dao.basebean.CourseSelection;
import com.wt.courseselectionsystem.model.dao.exbean.CoursePlanInfo;
import com.wt.courseselectionsystem.service.CourseSelectionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lixin
 */
@Service
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

    public CourseSelectionServiceImpl(CourseSelectionDao courseSelectionDao, CoursePlanDao coursePlanDao) {
        this.courseSelectionDao = courseSelectionDao;
        this.coursePlanDao = coursePlanDao;
    }

    @Override
    public NoDataResult selectCourse(String studentNo, String coursePlanNo) {
        Integer sumCredit = courseSelectionDao.selectSumCredit(studentNo);
        Integer creditStandard = 10;
        if (creditStandard.compareTo(sumCredit) >= 0) {
            return ResultUtils.fail("选课失败：学分已修满");
        }
        if (courseSelectionDao.countByStudentNoAndCoursePlanNo(studentNo, coursePlanNo) != 0) {
            return ResultUtils.fail("重复选课");
        }
        // 课程名额
        Integer quota;
        try {
            quota = quotaCache.get(coursePlanNo,
                    () -> Optional.ofNullable(coursePlanDao.selectInfoByCoursePlanNo(coursePlanNo))
                            .map(CoursePlanInfo::getStudentNumber)
                            .orElseThrow(() -> new RuntimeException("排课不存在")));
            synchronized (this) {
                usedQuotaCache.get(coursePlanNo,
                        () -> new AtomicInteger(courseSelectionDao.countByCoursePlanNo(coursePlanNo)));
            }
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        AtomicInteger usedQuota = Optional.ofNullable(usedQuotaCache.getIfPresent(coursePlanNo))
                .orElseThrow(() -> new RuntimeException("获取缓存失败"));
        if (quota.compareTo(usedQuota.getAndIncrement()) <= 0) {
            // 计划人数小于等于已选人数
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
}
