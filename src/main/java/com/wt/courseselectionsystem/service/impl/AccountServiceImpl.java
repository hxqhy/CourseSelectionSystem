package com.wt.courseselectionsystem.service.impl;

import com.wt.courseselectionsystem.common.ResultUtils;
import com.wt.courseselectionsystem.common.SystemUtils;
import com.wt.courseselectionsystem.common.constant.AccountConstant;
import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.dao.AccountDao;
import com.wt.courseselectionsystem.dao.StudentDao;
import com.wt.courseselectionsystem.dao.TeacherDao;
import com.wt.courseselectionsystem.model.dao.basebean.Account;
import com.wt.courseselectionsystem.model.dao.basebean.Student;
import com.wt.courseselectionsystem.model.dao.basebean.Teacher;
import com.wt.courseselectionsystem.model.vo.request.LoginForm;
import com.wt.courseselectionsystem.model.vo.request.account.*;
import com.wt.courseselectionsystem.model.vo.response.AccountVo;
import com.wt.courseselectionsystem.model.vo.response.LoginResult;
import com.wt.courseselectionsystem.service.AccountService;
import com.wt.courseselectionsystem.service.TokenService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.wt.courseselectionsystem.common.SystemUtils.*;

/**
 * 用户模块 业务实现类
 *
 * @author xxx
 */
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao;

    private final TokenService<Account> tokenService;

    private final TeacherDao teacherDao;

    private final StudentDao studentDao;

    public AccountServiceImpl(AccountDao accountDao, TokenService<Account> tokenService
            , TeacherDao teacherDao, StudentDao studentDao) {
        this.accountDao = accountDao;
        this.tokenService = tokenService;
        this.teacherDao = teacherDao;
        this.studentDao = studentDao;
    }

    /**
     * 根据用户和密码登录
     * 判断账户密码是否一致
     *
     * @param form ...
     * @return ...
     */
    @Override
    public DataResult<LoginResult> login(LoginForm form) {
        Account account = accountDao.selectByAccountNo(form.getAccount());
        if (Objects.isNull(account)) {
            throw new RuntimeException("账号密码错误");
        }
        String password = passwordEncode(form.getPassword());
        if (password.equals(account.getPassword())) {
            LoginResult result = new LoginResult();
            String token = tokenService.getToken(account);
            result.setToken(token);
            return ResultUtils.success(result);
        }
        throw new RuntimeException("账号密码错误");
    }

    @Override
    public DataResult<AccountVo> getAccountInfo(String token) {
        Account data = tokenService.getData(token);
        AccountVo vo = new AccountVo();
        BeanUtils.copyProperties(data, vo);
        return ResultUtils.success(vo);
    }

    @Override
    public NoDataResult activateStudentAccount(ActivateSingleAccountForm form) {
        Account accountNo = accountDao.selectByAccountNo(generateStudentAccountNo(form.getNumber()));
        if (accountNo != null) {
            return ResultUtils.fail("请选择学生账号或账号已激活");
        }

        Account account = new Account();
        account.setAccountNo(generateStudentAccountNo(form.getNumber()));
        account.setPassword(SystemUtils.passwordEncode(AccountConstant.DEFAULT_PASSWORD));
        account.setAccountType(AccountConstant.STUDENT_CODE);
        int i = accountDao.insertAccount(account);
        return i == 0 ? ResultUtils.fail("学生账号激活失败") : ResultUtils.success("学生账号激活成功");
    }

    @Override
    public NoDataResult activateTeacherAccount(ActivateSingleAccountForm form) {
        String s = generateTeacherAccountNo(form.getNumber());
        Account no = accountDao.selectByAccountNo(s);
        if (no != null) {
            return ResultUtils.fail("请选择教师账号或账号已激活");
        }
        Account account = new Account();
        account.setAccountNo(s);
        account.setPassword(SystemUtils.passwordEncode(AccountConstant.DEFAULT_PASSWORD));
        account.setAccountType(AccountConstant.TEACHER_CODE);
        int i = accountDao.insertAccount(account);
        if (i == 0) {
            return ResultUtils.fail("导师账号激活失败");
        }
        return ResultUtils.success("导师账号激活成功");
    }

    @Override
    public NoDataResult activateStudentList(ActiveStudentForm activeStudentForm) {
        List<String> studentNoList = Optional.ofNullable(activeStudentForm.getStudentNos())
                .orElse(Collections.emptyList());
        List<Account> accounts = studentNoList.stream()
                .filter(studentNo ->
                        Objects.isNull(accountDao.selectByAccountNo(generateStudentAccountNo(studentNo)))
                )
                .map(studentNo -> {
                    Account account = new Account();
                    account.setAccountNo(SystemUtils.generateStudentAccountNo(studentNo));
                    account.setPassword(passwordEncode(AccountConstant.DEFAULT_PASSWORD));
                    account.setAccountType(AccountConstant.STUDENT_CODE);
                    return account;
                }).collect(Collectors.toList());
        if (accounts.isEmpty()) {
            return ResultUtils.success("请选择学生账号或已经激活");
        }
        Integer row = accountDao.insertAccountList(accounts);
        return row.equals(accounts.size()) ? ResultUtils.success("学生账号批量激活成功")
                : ResultUtils.fail("学生账号批量激活失败");
    }

    @Override
    public NoDataResult activateTeacherList(ActivateTeacherForm activateTeacherForm) {
        List<String> teacherNos = activateTeacherForm.getTeacherNo();
        List<String> teacherList = Optional.ofNullable(teacherNos).orElse(Collections.emptyList());
        List<Account> collect = teacherList.stream()
                .filter(filterNo -> Objects.isNull(accountDao.selectByAccountNo(generateTeacherAccountNo(filterNo))))
                .map(item -> {
                    Account account = new Account();
                    account.setAccountNo(generateTeacherAccountNo(item));
                    account.setPassword(passwordEncode(AccountConstant.DEFAULT_PASSWORD));
                    account.setAccountType(AccountConstant.TEACHER_CODE);
                    return account;
                }).collect(Collectors.toList());

        if (collect.isEmpty()) {
            return ResultUtils.fail("请选择导师账号或账号已激活");
        }
        Integer row = accountDao.insertAccountList(collect);
        return row.equals(collect.size()) ? ResultUtils.success("导师账号批量激活成功")
                : ResultUtils.fail("导师账号批量激活失败");
    }

    @Override
    public NoDataResult updatePassword(UpdatePasswordForm passwordForm) {
        Account accountNo = accountDao.selectByAccountNo(passwordForm.getAccountNo());
        if (accountNo != null) {
            Account account = new Account();
            account.setAccountNo(passwordForm.getAccountNo());
            account.setPassword(passwordEncode(passwordForm.getPassword()));
            int row = accountDao.updatePassword(account);
            return row == 1 ? ResultUtils.success("修改密码成功") : ResultUtils.fail("修改密码失败");
        }
        return ResultUtils.fail("请先激活账号");
    }

    @Override
    public NoDataResult activateAllAccount(ActivateAllAccountForm allForm) {
        List<String> allAccount = Optional.ofNullable(allForm.getAllNumber()).orElse(Collections.emptyList());

        List<Account> all = allAccount.stream().filter(filterNo -> Objects.isNull(accountDao.selectByAccountNo(generateTeacherAccountNo(filterNo))))
                .filter(filterNo -> Objects.isNull(accountDao.selectByAccountNo(generateStudentAccountNo(filterNo))))
                .map(allAccountNo -> {
                    Teacher teacher = teacherDao.selectByTeacherNo(allAccountNo);
                    if (teacher != null) {
                        Account account = new Account();
                        account.setAccountNo(generateTeacherAccountNo(teacher.getTeacherNo()));
                        account.setPassword(passwordEncode(AccountConstant.DEFAULT_PASSWORD));
                        account.setAccountType(AccountConstant.TEACHER_CODE);
                        return account;
                    } else {
                        Account account = new Account();
                        account.setAccountNo(generateStudentAccountNo(allAccountNo));
                        account.setPassword(passwordEncode(AccountConstant.DEFAULT_PASSWORD));
                        account.setAccountType(AccountConstant.STUDENT_CODE);
                        return account;
                    }
                }).collect(Collectors.toList());
        if (all.isEmpty()) {
            return ResultUtils.fail("请选择账号或账号已激活");
        }
        Integer row = accountDao.insertAccountList(all);
        return row.equals(all.size()) ? ResultUtils.success("批量激活所有账号成功")
                : ResultUtils.fail("批量激活所有账号失败");
    }

    @Override
    public NoDataResult resetPassword(ResetPasswordForm resetForm) {
        Account accountNo = accountDao.selectByAccountNo(resetForm.getAccountNo());
        if (accountNo != null) {
            Account account = new Account();
            account.setAccountNo(resetForm.getAccountNo());
            account.setPassword(passwordEncode(AccountConstant.DEFAULT_PASSWORD));
            int row = accountDao.updatePassword(account);
            return row == 1 ? ResultUtils.success("重置密码成功") : ResultUtils.fail("重置密码失败");
        }
        return ResultUtils.fail("请先激活账号");
    }
}
