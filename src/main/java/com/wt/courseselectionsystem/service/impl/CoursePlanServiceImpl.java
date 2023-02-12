package com.wt.courseselectionsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wt.courseselectionsystem.common.ResultUtils;
import com.wt.courseselectionsystem.common.SystemUtils;
import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.dao.CoursePlanDao;
import com.wt.courseselectionsystem.model.dao.basebean.CoursePlan;
import com.wt.courseselectionsystem.model.vo.request.courseplan.CoursePlanAddForm;
import com.wt.courseselectionsystem.model.vo.request.courseplan.CoursePlanQuery;
import com.wt.courseselectionsystem.model.vo.request.courseplan.CoursePlanUpdateForm;
import com.wt.courseselectionsystem.model.vo.response.CoursePlanVo;
import com.wt.courseselectionsystem.service.CoursePlanService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        if (!Objects.isNull(coursePlanDao.selectByCoursePlan(form.getCoursePlanNo()))) {
            return ResultUtils.fail("课程计划编号重复");
        }
        CoursePlan coursePlan = new CoursePlan();
        BeanUtils.copyProperties(form, coursePlan);
        int rows = coursePlanDao.insertCoursePlan(coursePlan);
        if (rows == 1) {
            return ResultUtils.success("添加成功");
        } else {
            return ResultUtils.fail("添加失败");
        }
    }

    @Override
    public DataResult<List<CoursePlanVo>> list(CoursePlanQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<CoursePlan> list = coursePlanDao.select(query);
        List<CoursePlanVo> coursePlanVos = SystemUtils.easyCopy(list, CoursePlanVo.class);
        PageInfo<CoursePlanVo> info = new PageInfo<>(coursePlanVos);
        return ResultUtils.success(info.getList());
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
        CoursePlan coursePlan = coursePlanDao.selectByCoursePlan(coursePlanNo);
        BeanUtils.copyProperties(coursePlan, coursePlanVo);

        return ResultUtils.success(coursePlanVo);
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
}
