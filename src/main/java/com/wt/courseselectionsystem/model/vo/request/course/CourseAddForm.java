package com.wt.courseselectionsystem.model.vo.request.course;

import lombok.Data;

/**
 * @author xxx
 */
@Data
public class CourseAddForm {
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
     * 名额
     */
    private Integer quota;

}
