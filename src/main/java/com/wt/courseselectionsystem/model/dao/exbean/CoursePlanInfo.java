package com.wt.courseselectionsystem.model.dao.exbean;

import lombok.Data;

/**
 * @author HY
 */
@Data
public class CoursePlanInfo {
    /**
     * 课程计划编号
     */
    private String coursePlanNo;
    /**
     * 课程号
     */
    private String courseNo;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 授课老师编号
     */
    private String teacherNo;
    /**
     * 教师名称
     */
    private String teacherName;

}
