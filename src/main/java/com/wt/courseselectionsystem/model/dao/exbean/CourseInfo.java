package com.wt.courseselectionsystem.model.dao.exbean;

import lombok.Data;

/**
 * 课程
 *
 * @author xxx
 */
@Data
public class CourseInfo {
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
    private Integer studentNumber;

}
