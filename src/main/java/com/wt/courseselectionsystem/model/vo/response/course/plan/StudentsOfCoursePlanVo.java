package com.wt.courseselectionsystem.model.vo.response.course.plan;

import com.wt.courseselectionsystem.model.vo.response.base.PageResponse;
import com.wt.courseselectionsystem.model.vo.response.student.StudentVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author lixin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class StudentsOfCoursePlanVo extends PageResponse {
    private List<StudentVo> list;
}
