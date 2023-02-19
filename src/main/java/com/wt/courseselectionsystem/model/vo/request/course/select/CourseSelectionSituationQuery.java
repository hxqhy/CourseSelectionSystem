package com.wt.courseselectionsystem.model.vo.request.course.select;

import com.wt.courseselectionsystem.model.vo.request.base.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lixin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CourseSelectionSituationQuery extends PageRequest {

    /**
     * 学号
     */
    private String studentNo;

    /**
     * 教师编号
     */
    private String teacherNo;

    /**
     * 课程名
     */
    private String courseName;

}
