package com.wt.courseselectionsystem.model.vo.response.course;

import lombok.Data;

/**
 * @author xxx
 */
@Data
public class CourseVo {
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

}
