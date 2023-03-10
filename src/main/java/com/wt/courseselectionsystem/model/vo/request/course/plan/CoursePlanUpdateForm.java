package com.wt.courseselectionsystem.model.vo.request.course.plan;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author xxx
 */
@Data
public class CoursePlanUpdateForm {
    @NotBlank(message = "课程计划号不能为空")
    @Length(max = 22, message = "长度不能超过22位")
    private String coursePlanNo;

    @NotBlank(message = "课程号不能为空")
    @Length(max = 6, message = "长度不能超过6位")
    private String courseNo;

    @NotBlank(message = "教师编号不能为空")
    @Length(max = 12, message = "长度不能超过12位")
    private String teacherNo;
    
    @NotBlank(message = "教师编号不能为空")
    private String coursePlanYear;
}
