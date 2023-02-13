package com.wt.courseselectionsystem.model.vo.request.course.plan;

import lombok.Data;

/**
 * @author xxx
 */
@Data
public class CoursePlanAddForm {
   
    /**
     * 课程号
     */
    private String courseNo;
    /**
     * 授课老师编号
     */
    private String teacherNo;
}
