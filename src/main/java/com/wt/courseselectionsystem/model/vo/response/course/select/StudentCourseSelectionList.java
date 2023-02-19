package com.wt.courseselectionsystem.model.vo.response.course.select;

import lombok.Data;

import java.util.List;

/**
 * @author lixin
 */
@Data
public class StudentCourseSelectionList {
    private List<CourseInfoForStudentVo> list;
}
