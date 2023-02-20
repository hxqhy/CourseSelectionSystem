package com.wt.courseselectionsystem.model.vo.request.account;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class ActivateTeacherForm {

    @NotEmpty(message = "批量激活教师,编号不能为空")
    public List<@NotBlank(message = "教师编号不能为空") String> teacherNo;
}
