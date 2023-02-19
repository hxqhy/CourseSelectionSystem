package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.common.result.NoDataResult;

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
}
