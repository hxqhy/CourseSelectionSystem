package com.wt.courseselectionsystem.model.vo.request.account;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author mry5l
 */
@Data
public class UpdatePasswordForm {

    @NotBlank(message = "账号不能为空")
    @Length(max = 13, message = "长度不能超过13位")
    private String accountNo;

    @NotBlank(message = "密码不能为空")
    private String password;

}
