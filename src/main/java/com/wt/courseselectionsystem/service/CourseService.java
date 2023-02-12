package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.model.vo.request.course.CourseAddForm;
import com.wt.courseselectionsystem.model.vo.request.course.CourseQuery;
import com.wt.courseselectionsystem.model.vo.request.course.CourseUpdateForm;
import com.wt.courseselectionsystem.model.vo.response.CourseVo;

import java.util.List;

/**
 * @author HY
 */
public interface CourseService {
    /**
     * 添加课程
     *
     * @param form ...
     * @return ...
     */
    NoDataResult addCourse(CourseAddForm form);

    /**
     * 条件查询
     *
     * @param query ...
     * @return ...
     */
    DataResult<List<CourseVo>> list(CourseQuery query);

    /**
     * 修改
     *
     * @param form ...
     * @return ...
     */
    NoDataResult update(CourseUpdateForm form);

    /**
     * 查询课程信息
     *
     * @param courseNo ...
     * @return ...
     */
    DataResult<CourseVo> info(String courseNo);

    /**
     * 删除信息
     *
     * @param courseNo ...
     * @return ...
     */
    NoDataResult delete(String courseNo);
}
