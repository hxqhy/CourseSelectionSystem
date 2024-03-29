package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.model.vo.request.course.CourseAddForm;
import com.wt.courseselectionsystem.model.vo.request.course.CourseListQuery;
import com.wt.courseselectionsystem.model.vo.request.course.CourseUpdateForm;
import com.wt.courseselectionsystem.model.vo.response.course.CourseListVo;
import com.wt.courseselectionsystem.model.vo.response.course.CourseSelectListVo;
import com.wt.courseselectionsystem.model.vo.response.course.CourseVo;

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
     * @return list
     */
    DataResult<CourseListVo> list(CourseListQuery query);

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

    /**
     * selectionList
     *
     * @param courseNo ...
     * @return com.wt.courseselectionsystem.common.result.DataResult<com.wt.courseselectionsystem.model.vo.response.course.CourseSelectListVo>
     * @date 2023/3/18 17:13
     **/
    DataResult<CourseSelectListVo> selectionList(String courseNo);
}
