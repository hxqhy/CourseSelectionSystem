package com.wt.courseselectionsystem.model.dao.exbean;

import lombok.Data;

/**
 * @author lixin
 */
@Data
public class CourseInfoForStudent {
    
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
