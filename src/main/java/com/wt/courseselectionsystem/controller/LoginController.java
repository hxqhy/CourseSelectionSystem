package com.wt.courseselectionsystem.controller;

import com.wt.courseselectionsystem.common.BaseResult;
import com.wt.courseselectionsystem.model.vo.request.LoginForm;
import com.wt.courseselectionsystem.model.vo.result.LoginResult;
import com.wt.courseselectionsystem.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统用户登录 控制
 *
 * @author xxx
 */
@RestController
public class LoginController {

    private final AccountService accountService;

    public LoginController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 功能描述：系统用户登录
     */
    @PostMapping("/account_login")
    public BaseResult<LoginResult> accountLogin(@RequestBody LoginForm form) {
        return accountService.login(form);
    }
}
