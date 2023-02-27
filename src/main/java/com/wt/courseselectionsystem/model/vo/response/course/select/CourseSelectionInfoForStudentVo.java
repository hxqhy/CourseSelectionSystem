package com.wt.courseselectionsystem.model.vo.response.course.select;

import lombok.Data;

/**
 * @author lixin
 */
@Data
public class CourseSelectionInfoForStudentVo {

    /**
     * 课程计划编号
     */
    private String coursePlanNo;

    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 教师名称
     */
    private String teacherName;
    /**
     * 学分
     */
    private Integer credit;
    /**
     * 学时
     */
    private Integer courseHours;

    /**
     * 开课年份
     */
    private String coursePlanYear;
}
