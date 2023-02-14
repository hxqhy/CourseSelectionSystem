package com.wt.courseselectionsystem.controller;

import com.wt.courseselectionsystem.common.ResultUtils;
import com.wt.courseselectionsystem.common.annotation.LoginRequired;
import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.model.dao.basebean.Account;
import com.wt.courseselectionsystem.model.vo.request.LoginForm;
import com.wt.courseselectionsystem.model.vo.request.account.ActiveStudentForm;
import com.wt.courseselectionsystem.model.vo.response.AccountVo;
import com.wt.courseselectionsystem.model.vo.response.LoginResult;
import com.wt.courseselectionsystem.service.AccountService;
import com.wt.courseselectionsystem.service.TokenService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wt.courseselectionsystem.common.constant.AccountConstant.ADMIN_CODE;

/**
 * 系统用户登录 控制
 *
 * @author xxx
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;


    private final TokenService<Account> tokenService;

    public AccountController(AccountService accountService, TokenService<Account> tokenService) {
        this.accountService = accountService;
        this.tokenService = tokenService;
    }

    /**
     * 功能描述：系统用户登录
     */
    @PostMapping("/login")
    public DataResult<LoginResult> accountLogin(@RequestBody LoginForm form) {
        return accountService.login(form);
    }

    @GetMapping("/logout")
    public NoDataResult logout(@RequestHeader(value = "token") String token) {
        tokenService.removeToken(token);
        return ResultUtils.success();
    }

    @LoginRequired
    @GetMapping("/info")
    public DataResult<AccountVo> getAccount(@RequestHeader(value = "token") String token) {
        return accountService.getAccountInfo(token);
    }

    @LoginRequired(role = {ADMIN_CODE})
    @PostMapping("/activeStudent")
    public NoDataResult activateStudentAccount(String studentNo) {
        return accountService.activateStudentAccount(studentNo);
    }

    @LoginRequired(role = {ADMIN_CODE})
    @PostMapping("/activeTeacher")
    public NoDataResult activateTeacherAccount(String teacherNo) {
        return accountService.activateStudentAccount(teacherNo);
    }


    @LoginRequired(role = {ADMIN_CODE})
    @PostMapping("list/activeStudent")
    public NoDataResult activateStudentList(@RequestBody ActiveStudentForm activeStudentForm) {
        return accountService.activateStudentList(activeStudentForm);
    }
}
