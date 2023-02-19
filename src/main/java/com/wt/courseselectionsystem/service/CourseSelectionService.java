package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.model.vo.request.course.select.CourseSelectionSituationQuery;
import com.wt.courseselectionsystem.model.vo.response.course.select.CourseSelectionSituationListVo;
import org.springframework.web.bind.annotation.RequestBody;

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
     * 获取选课情况列表
     *
     * @param query ...
     * @return ...
     */
    DataResult<CourseSelectionSituationListVo> infoList(CourseSelectionSituationQuery query);
}
