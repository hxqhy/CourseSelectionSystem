package com.wt.courseselectionsystem.model.vo.request.account;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author mry5l
 */

@Data
public class ResetPasswordForm {

    @NotBlank(message = "重置密码账号不能为空")
    @Length(max = 13, message = "重置密码账号长度不能超过13位")
    private String accountNo;
}
