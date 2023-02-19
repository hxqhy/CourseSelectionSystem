package com.wt.courseselectionsystem.model.vo.response.teacher;

import lombok.Data;

@Data
public class TeacherDetails {
    /**
     * 课程计划编号
     */
    private String coursePlanNo;

    /**
     * 教师名称
     */
    private String teacherName;
    /**
     * 课程号
     */
    private String courseNo;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 学分
     */
    private Integer credit;
    /**
     * 学时
     */
    private Integer courseHours;
    /**
     * 学生人数
     */
    private Integer quota;
    /**
     * 开课年份
     */
    private String coursePlanYear;

    /**
     * 学生姓名
     */
    private String studentName;
}
