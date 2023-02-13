package com.wt.courseselectionsystem.model.vo.request.course.plan;

import com.wt.courseselectionsystem.model.vo.request.base.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xxx
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CoursePlanQuery extends PageRequest {
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
}
