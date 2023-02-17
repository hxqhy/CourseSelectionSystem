package com.wt.courseselectionsystem.model.vo.request.course.plan;

import lombok.Data;

/**
 * @author xxx
 */
@Data
public class CoursePlanUpdateForm {
  
    private String coursePlanNo;
    private String courseNo;

    private String teacherNo;

    private String coursePlanYear;
}
