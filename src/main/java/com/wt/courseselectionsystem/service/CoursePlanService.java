package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanAddForm;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanInfoQuery;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanUpdateForm;
import com.wt.courseselectionsystem.model.vo.response.course.plan.CoursePlanListVo;
import com.wt.courseselectionsystem.model.vo.response.course.plan.CoursePlanVo;

/**
 * @author HY
 */
public interface CoursePlanService {
    /**
     * 添加课程计划
     *
     * @param form ...
     * @return ...
     */
    NoDataResult addCoursePlan(CoursePlanAddForm form);

    /**
     * 条件查询课程计划
     *
     * @param query ...
     * @return ...
     */
    DataResult<CoursePlanListVo> list(CoursePlanInfoQuery query);

    /**
     * 修改课程计划
     *
     * @param form ...
     * @return ...
     */
    NoDataResult update(CoursePlanUpdateForm form);

    /**
     * 查询课程详情
     *
     * @param coursePlanNo ...
     * @return ...
     */
    DataResult<CoursePlanVo> info(String coursePlanNo);

    /**
     * 删除
     *
     * @param coursePlanNo ...
     * @return ...
     */
    NoDataResult delete(String coursePlanNo);
}
