package com.wt.courseselectionsystem.model.vo.request.student;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author lixin
 */
@Data
public class StudentUpdateForm {
    /**
     * 学生学号
     */
    @NotBlank(message = "学号不能为空")
    @Length(max = 12, message = "长度不能超过12位")
    private String studentNo;
    /**
     * 学生名称
     */
    @NotBlank(message = "名字不能为空")
    private String studentName;
    /**
     * 性别
     */
    @NotNull(message = "性别不能为空")
    private Integer gender;
    /**
     * 班级
     */
    @NotBlank(message = "班级不能为空")
    private String studentClass;
}
