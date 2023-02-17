package com.wt.courseselectionsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wt.courseselectionsystem.common.ResultUtils;
import com.wt.courseselectionsystem.common.SystemUtils;
import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.dao.CoursePlanDao;
import com.wt.courseselectionsystem.model.dao.basebean.CoursePlan;
import com.wt.courseselectionsystem.model.dao.exbean.CoursePlanInfo;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanAddForm;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanInfoQuery;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanUpdateForm;
import com.wt.courseselectionsystem.model.vo.request.course.plan.StudentsOfCoursePlanForm;
import com.wt.courseselectionsystem.model.vo.response.StudentsOfCoursePlanVo;
import com.wt.courseselectionsystem.model.vo.response.course.plan.CoursePlanListVo;
import com.wt.courseselectionsystem.model.vo.response.course.plan.CoursePlanVo;
import com.wt.courseselectionsystem.service.CoursePlanService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author HY
 */
@Service
public class CoursePlanServiceImpl implements CoursePlanService {

    public CoursePlanServiceImpl(CoursePlanDao coursePlanDao) {
        this.coursePlanDao = coursePlanDao;
    }

    private final CoursePlanDao coursePlanDao;

    @Override
    public NoDataResult addCoursePlan(CoursePlanAddForm form) {
        LocalDate now = LocalDate.now();
        String coursePlanNo = generateCoursePlanNo(form, now);
        if (!Objects.isNull(coursePlanDao.selectInfoByCoursePlanNo(coursePlanNo))) {
            throw new RuntimeException("排课已存在");
        }
        CoursePlan coursePlan = new CoursePlan();
        BeanUtils.copyProperties(form, coursePlan);
        coursePlan.setCoursePlanNo(coursePlanNo);
        coursePlan.setCoursePlanYear(String.valueOf(now.getYear()));
        int rows = coursePlanDao.insertCoursePlan(coursePlan);
        if (rows == 1) {
            return ResultUtils.success("添加成功");
        } else {
            return ResultUtils.fail("添加失败");
        }
    }

    @Override
    public DataResult<CoursePlanListVo> list(CoursePlanInfoQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<CoursePlanInfo> list = coursePlanDao.selectCoursePlanInfo(query);
        PageInfo<CoursePlanInfo> info = new PageInfo<>(list);
        CoursePlanListVo result = new CoursePlanListVo();
        result.setList(SystemUtils.easyCopy(list, CoursePlanVo.class));
        SystemUtils.configPageInfo(result, info);
        return ResultUtils.success(result);
    }

    @Override
    public NoDataResult update(CoursePlanUpdateForm form) {
        CoursePlan coursePlan = new CoursePlan();
        BeanUtils.copyProperties(form, coursePlan);
        int rows = coursePlanDao.updateInfo(coursePlan);
        if (rows == 1) {
            return ResultUtils.success("添加成功");
        } else {
            return ResultUtils.fail("添加失败");
        }

    }

    @Override
    public DataResult<CoursePlanVo> info(String coursePlanNo) {
        CoursePlanVo coursePlanVo = new CoursePlanVo();
        CoursePlanInfo info = Optional.ofNullable(coursePlanDao.selectInfoByCoursePlanNo(coursePlanNo))
                .orElse(new CoursePlanInfo());
        BeanUtils.copyProperties(info, coursePlanVo);
        return ResultUtils.success(coursePlanVo);
    }

    @Override
    public DataResult<StudentsOfCoursePlanVo> students(StudentsOfCoursePlanForm form) {
        // todo 业务逻辑
        return null;
    }

    @Override
    public NoDataResult delete(String coursePlanNo) {
        int rows = coursePlanDao.delete(coursePlanNo);
        if (rows == 1) {
            return ResultUtils.success("删除成功");
        } else {
            return ResultUtils.fail("删除失败");
        }
    }

    private String generateCoursePlanNo(CoursePlanAddForm form, LocalDate date) {
        return form.getTeacherNo() + form.getCourseNo() + date.getYear();
    }
}
