package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.model.vo.request.course.select.CourseSelectionSituationQuery;
import com.wt.courseselectionsystem.model.vo.request.course.select.CreditsSummaryQuery;
import com.wt.courseselectionsystem.model.vo.response.course.select.CourseSelectionSituationListVo;
import com.wt.courseselectionsystem.model.vo.response.course.select.CreditsSummaryListVo;
import com.wt.courseselectionsystem.model.vo.response.course.select.StudentCourseSelectionList;

/**
 * @author lixin
 */
public interface CourseSelectionService {

    /**
     * 选课
     *
     * @param studentNo    ...
     * @param coursePlanNo ...
     * @return result
     */
    NoDataResult selectCourse(String studentNo, String coursePlanNo);

    /**
     * 学分汇总信息
     *
     * @param query ...
     * @return ...
     */
    DataResult<CreditsSummaryListVo> summary(CreditsSummaryQuery query);

    /**
     * 获取选课情况列表
     *
     * @param query ...
     * @return ...
     */
    DataResult<CourseSelectionSituationListVo> infoList(CourseSelectionSituationQuery query);

    /**
     * 取消选课
     *
     * @param coursePlanNo ...
     * @param studentNo    ...
     * @return ...
     */
    NoDataResult cancel(String coursePlanNo, String studentNo);

    /**
     * 获取学生选课列表
     *
     * @param studentNo ...
     * @return ...
     */
    DataResult<StudentCourseSelectionList> list(String studentNo);
}
