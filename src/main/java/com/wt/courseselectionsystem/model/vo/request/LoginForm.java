package com.wt.courseselectionsystem.model.vo.request;

import lombok.Data;

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
    private String account;

    /**
     * 密码
     */
    private String password;
}
