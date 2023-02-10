package com.wt.courseselectionsystem.controller;

import com.wt.courseselectionsystem.common.BaseResult;
import com.wt.courseselectionsystem.model.vo.request.LoginForm;
import com.wt.courseselectionsystem.model.vo.result.AccountVo;
import com.wt.courseselectionsystem.model.vo.result.LoginResult;
import com.wt.courseselectionsystem.service.AccountService;
import org.springframework.web.bind.annotation.*;

/**
 * 系统用户登录 控制
 *
 * @author xxx
 */
@RestController
@RequestMapping("/account")
public class LoginController {

    private final AccountService accountService;

    public LoginController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 功能描述：系统用户登录
     */
    @PostMapping("/login")
    public BaseResult<LoginResult> accountLogin(@RequestBody LoginForm form) {
        return accountService.login(form);
    }

    @GetMapping("/info")
    public BaseResult<AccountVo> getAccount(@RequestHeader(value = "token") String token) {
        return accountService.getAccountInfo(token);
    }
}
