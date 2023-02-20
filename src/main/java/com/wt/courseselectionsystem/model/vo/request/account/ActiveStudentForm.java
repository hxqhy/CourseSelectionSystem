package com.wt.courseselectionsystem.model.vo.request.account;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author lixin
 */
@Data
public class ActiveStudentForm {
    @NotEmpty(message = "批量激活学生,编号不能为空")
    private List<@NotEmpty(message = "学生编号不能为空") String> studentNos;
}
