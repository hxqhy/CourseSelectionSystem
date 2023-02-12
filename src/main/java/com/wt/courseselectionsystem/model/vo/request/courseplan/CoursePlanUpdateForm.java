package com.wt.courseselectionsystem.model.vo.request.courseplan;

import lombok.Data;

/**
 * @author xxx
 */
@Data
public class CoursePlanUpdateForm {
    /**
     * 课程计划编号
     */
    private String coursePlanNo;
    /**
     * 课程号
     */
    private String courseNo;
    /**
     * 授课老师编号
     */
    private String teacherNo;
}
