package com.wt.courseselectionsystem.model.vo.request.course.plan;

import com.wt.courseselectionsystem.model.vo.request.base.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lixin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class StudentsOfCoursePlanForm extends PageRequest {
    private String coursePlanNo;
}
