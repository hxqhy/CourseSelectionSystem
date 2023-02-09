package com.wt.courseselectionsystem.model.dao.basebean;

import lombok.Data;

/**
 * 课程
 */
@Data
public class Course {

    /**
     * 课程id
     */
    private String id;
    //课程号
    private String courseNo;
    //课程名称
    private String courseName;
    //学分
    private Integer credit;
    //学时
    private Integer courseHours;
    //学生人数
    private Integer studentNumber;

}
