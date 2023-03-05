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
import com.wt.courseselectionsystem.model.vo.request.student.StudentListQuery;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherListQuery;
import com.wt.courseselectionsystem.model.vo.response.AccountVo;
import com.wt.courseselectionsystem.model.vo.response.LoginResult;
import com.wt.courseselectionsystem.service.AccountService;
import com.wt.courseselectionsystem.service.TokenService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.wt.courseselectionsystem.common.SystemUtils.*;
import static com.wt.courseselectionsystem.common.constant.AccountConstant.QUERY_ACTIVE_CODE_IS_ACTIVE;

/**
 * 用户模块 业务实现类
 *
 * @author xxx
 */
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao;

    private final TokenService<Account> tokenService;

    private final StudentDao studentDao;

    private final TeacherDao teacherDao;

    public AccountServiceImpl(AccountDao accountDao, TokenService<Account> tokenService,
                              StudentDao studentDao, TeacherDao teacherDao) {
        this.accountDao = accountDao;
        this.tokenService = tokenService;
        this.studentDao = studentDao;
        this.teacherDao = teacherDao;
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
        List<Account> accounts = studentNoToAccount(studentNoList);
        if (accounts.isEmpty()) {
            return ResultUtils.success("请选择学生账号或已经激活");
        }
        Integer row = accountDao.insertAccountList(accounts);
        return row.equals(accounts.size()) ? ResultUtils.success("学生账号批量激活成功")
                : ResultUtils.fail("学生账号批量激活失败");
    }

    @Override
    public NoDataResult activateTeacherList(ActivateTeacherForm activateTeacherForm) {
        List<String> teacherList = Optional.ofNullable(activateTeacherForm.getTeacherNo())
                .orElse(Collections.emptyList());
        List<Account> collect = teacherNoToAccount(teacherList);

        if (collect.isEmpty()) {
            return ResultUtils.fail("请选择导师账号或账号已激活");
        }
        Integer row = accountDao.insertAccountList(collect);
        return row.equals(collect.size()) ? ResultUtils.success("导师账号批量激活成功")
                : ResultUtils.fail("导师账号批量激活失败");
    }

    @Override
    public NoDataResult updatePassword(UpdatePasswordForm form) {
        String nowPassword = Optional.ofNullable(accountDao.selectByAccountNo(form.getAccountNo()))
                .map(Account::getPassword)
                .orElseThrow(() -> new RuntimeException("账号不存在"));
        if (nowPassword.equals(SystemUtils.passwordEncode(form.getOldPassword()))) {
            Account account = new Account();
            account.setAccountNo(form.getAccountNo());
            account.setPassword(passwordEncode(form.getNewPassword()));
            int row = accountDao.updatePassword(account);
            return row == 1 ? ResultUtils.success("修改密码成功") : ResultUtils.fail("修改密码失败");
        } else {
            throw new RuntimeException("密码错误");
        }
    }

    @Override
    public NoDataResult activateAllStudents() {
        return activateAll(() -> {
            StudentListQuery query = new StudentListQuery();
            query.setActive(QUERY_ACTIVE_CODE_IS_ACTIVE);
            List<String> numbers = studentDao.selectStudentInfo(query).stream()
                    .map(Student::getStudentNo).collect(Collectors.toList());
            return studentNoToAccount(numbers);
        });
    }

    @Override
    public NoDataResult activateAllTeacher() {
        return activateAll(() -> {
            TeacherListQuery query = new TeacherListQuery();
            query.setActive(QUERY_ACTIVE_CODE_IS_ACTIVE);
            List<String> numbers = teacherDao.selectTeacherInfo(query).stream()
                    .map(Teacher::getTeacherNo).collect(Collectors.toList());
            return teacherNoToAccount(numbers);
        });
    }

    /**
     * 使用到策略模式
     *
     * @param supplier supplier
     * @return NoDataResult
     */
    private NoDataResult activateAll(Supplier<List<Account>> supplier) {
        List<Account> accounts = supplier.get();
        Integer row = accountDao.insertAccountList(accounts);
        return row.equals(accounts.size()) ? ResultUtils.success("账号批量激活成功")
                : ResultUtils.fail("账号批量激活失败");
    }

    @Override
    public NoDataResult resetPassword(ResetPasswordForm resetForm) {
        Account account = Optional.ofNullable(accountDao.selectByAccountNo(resetForm.getAccountNo()))
                .orElseThrow(() -> new RuntimeException("账号不存在"));
        account.setAccountNo(resetForm.getAccountNo());
        account.setPassword(passwordEncode(AccountConstant.DEFAULT_PASSWORD));
        int row = accountDao.updatePassword(account);
        return row == 1 ? ResultUtils.success("重置密码成功") : ResultUtils.fail("重置密码失败");
    }

    /**
     * 根据学生编号生成Account对象
     *
     * @param numbers studentNo
     * @return accounts
     */
    private List<Account> studentNoToAccount(List<String> numbers) {
        if (CollectionUtils.isEmpty(numbers)) {
            return Collections.emptyList();
        }
        return numbers.stream()
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
    }

    /**
     * 根据教师编号生成Account对象
     *
     * @param numbers studentNo
     * @return accounts
     */
    private List<Account> teacherNoToAccount(List<String> numbers) {
        if (CollectionUtils.isEmpty(numbers)) {
            return Collections.emptyList();
        }
        return numbers.stream()
                .filter(number ->
                        Objects.isNull(accountDao.selectByAccountNo(generateTeacherAccountNo(number)))
                )
                .map(number -> {
                    Account account = new Account();
                    account.setAccountNo(SystemUtils.generateTeacherAccountNo(number));
                    account.setPassword(passwordEncode(AccountConstant.DEFAULT_PASSWORD));
                    account.setAccountType(AccountConstant.TEACHER_CODE);
                    return account;
                }).collect(Collectors.toList());
    }

}
