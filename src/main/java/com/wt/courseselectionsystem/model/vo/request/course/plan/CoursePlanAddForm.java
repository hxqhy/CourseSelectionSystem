package com.wt.courseselectionsystem.model.vo.request.course.plan;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author xxx
 */
@Data
public class CoursePlanAddForm {

    /**
     * 课程号
     */
    @NotBlank(message = "课程号不能为空")
    @Length(max = 6, message = "长度不能超过6位")
    private String courseNo;
    /**
     * 授课老师编号
     */
    @NotBlank(message = "教师号不能为空")
    @Length(max = 12, message = "长度不能超过12位")
    private String teacherNo;

}
