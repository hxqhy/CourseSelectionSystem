package com.wt.courseselectionsystem.model.vo.response.course.select;

import lombok.Data;

/**
 * @author lixin
 */
@Data
public class CourseSelectionSituationVo {
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
