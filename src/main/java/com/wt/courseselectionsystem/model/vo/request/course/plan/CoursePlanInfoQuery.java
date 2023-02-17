package com.wt.courseselectionsystem.model.vo.request.course.plan;

import com.wt.courseselectionsystem.model.vo.request.base.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lixin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CoursePlanInfoQuery extends PageRequest {
    /**
     * 课程计划号
     */
    private String coursePlanNo;
    /**
     * 课程号
     */
    private String courseNo;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 授课老师编号
     */
    private String teacherNo;
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
     * 学生人数
     */
    private Integer quota;
    /**
     * 开课年份
     */
    private String coursePlanYear;
}
