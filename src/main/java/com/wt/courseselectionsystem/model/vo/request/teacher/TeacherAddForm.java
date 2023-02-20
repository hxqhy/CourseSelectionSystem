package com.wt.courseselectionsystem.model.vo.request.teacher;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author xxx
 */
@Data
public class TeacherAddForm {
    /**
     * 教师编号
     */
    @NotBlank(message = "编号不能为空")
    @Length(max = 12, message = "长度不能超过12位")
    private String teacherNo;
    /**
     * 教师名称
     */
    @NotBlank(message = "名字不能为空")
    private String teacherName;
    /**
     * 性别
     */
    @NotBlank(message = "性别不能为空")
    private Integer gender;
}
