package com.wt.courseselectionsystem.model.vo.request.course;

import com.wt.courseselectionsystem.model.vo.request.base.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xxx
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CourseListQuery extends PageRequest {
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
