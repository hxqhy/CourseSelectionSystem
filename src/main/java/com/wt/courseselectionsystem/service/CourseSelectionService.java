package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.model.vo.request.course.select.CreditsSummaryQuery;
import com.wt.courseselectionsystem.model.vo.response.course.select.CreditsSummaryListVo;

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
}
