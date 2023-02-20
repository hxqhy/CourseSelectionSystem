package com.wt.courseselectionsystem.model.vo.request.account;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author mry5l
 */

@Data
public class ActivateSingleAccountForm {

    @Pattern(regexp = "^[\\d]{12}",message = "不为纯数字并且长度不能超过12位")
    @NotBlank(message = "编号不能为空")
    private String number;

}
