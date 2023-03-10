package com.wt.courseselectionsystem.controller;

import com.wt.courseselectionsystem.common.ResultUtils;
import com.wt.courseselectionsystem.common.annotation.LoginRequired;
import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.model.dao.basebean.Account;
import com.wt.courseselectionsystem.model.vo.request.LoginForm;
import com.wt.courseselectionsystem.model.vo.request.account.*;
import com.wt.courseselectionsystem.model.vo.response.AccountVo;
import com.wt.courseselectionsystem.model.vo.response.LoginResult;
import com.wt.courseselectionsystem.service.AccountService;
import com.wt.courseselectionsystem.service.TokenService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.wt.courseselectionsystem.common.constant.AccountConstant.ADMIN_CODE;

/**
 * 系统用户登录 控制
 *
 * @author xxx
 */
@RestController
@RequestMapping("/account")
@LoginRequired(role = {ADMIN_CODE})
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
    public DataResult<LoginResult> accountLogin(@Validated @RequestBody LoginForm form) {
        return accountService.login(form);
    }

    @LoginRequired
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

    @PostMapping("/active_student")
    public NoDataResult activateStudentAccount(@Validated @RequestBody ActivateSingleAccountForm form) {
        return accountService.activateStudentAccount(form);
    }

    @PostMapping("/active_teacher")
    public NoDataResult activateTeacherAccount(@Validated @RequestBody ActivateSingleAccountForm form) {
        return accountService.activateTeacherAccount(form);
    }

    @LoginRequired
    @PostMapping("/update_password")
    NoDataResult updatePassword(@Validated @RequestBody UpdatePasswordForm passwordForm) {
        return accountService.updatePassword(passwordForm);
    }

    @PostMapping("/active_list_student")
    public NoDataResult activateStudentList(@Validated @RequestBody ActiveStudentForm activeStudentForm) {
        return accountService.activateStudentList(activeStudentForm);
    }

    @PostMapping("/active_list_teacher")
    public NoDataResult activateTeacherList(@Validated @RequestBody ActivateTeacherForm activateTeacherForm) {
        return accountService.activateTeacherList(activateTeacherForm);
    }

    @PostMapping("/activate_all_student")
    public NoDataResult activateAllStudent() {
        return accountService.activateAllStudents();
    }

    @PostMapping("/activate_all_teacher")
    public NoDataResult activateAllTeacher() {
        return accountService.activateAllTeacher();
    }

    /**
     * 重制密码
     *
     * @param resetPasswordForm ...
     * @return ...
     */
    @PostMapping("/reset_password")
    public NoDataResult resetPassword(@Validated @RequestBody ResetPasswordForm resetPasswordForm) {
        return accountService.resetPassword(resetPasswordForm);
    }
}
