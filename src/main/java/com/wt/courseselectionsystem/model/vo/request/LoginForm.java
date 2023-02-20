package com.wt.courseselectionsystem.model.vo.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * 登陆表单
 *
 * @author lixin
 */
@Data
public class LoginForm {

    /**
     * 账号
     */
    @NotBlank(message = "账号不能为空")
    @Length(max = 13,message = "账号长度不能超过13位")
    private String account;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;
}
