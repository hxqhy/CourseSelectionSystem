package com.wt.courseselectionsystem.model.dao.basebean;

import lombok.Data;

/**
 * 选课表
 *  @author xxx
 */
@Data
public class CourseSelection {
    private String id;
    /**课程计划编号*/
    private String coursePlanNo;
    /**学生学号*/
    private String studentNo;

    }
