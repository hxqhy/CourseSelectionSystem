package com.wt.courseselectionsystem.model.dao.exbean;

import lombok.Data;

@Data
public class CourseSelectionSituationInfo {
    private String studentName;
    private String studentNo;
    private String courseName;
    private String courseNo;
    private String teacherName;
    private String teacherNo;
    /**
     * 学分
     */
    private Integer credit;
    /**
     * 学时
     */
    private Integer courseHours;
}
