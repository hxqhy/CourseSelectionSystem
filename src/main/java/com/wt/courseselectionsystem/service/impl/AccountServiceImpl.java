package com.wt.courseselectionsystem.service.impl;

import com.wt.courseselectionsystem.common.BaseResult;
import com.wt.courseselectionsystem.common.ResultUtils;
import com.wt.courseselectionsystem.dao.AccountDao;
import com.wt.courseselectionsystem.model.dao.basebean.Account;
import com.wt.courseselectionsystem.model.vo.request.LoginForm;
import com.wt.courseselectionsystem.model.vo.result.LoginResult;
import com.wt.courseselectionsystem.service.AccountService;
import com.wt.courseselectionsystem.service.TokenService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * 用户模块 业务实现类
 *
 * @author xxx
 */
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao;

    private final TokenService<Account> tokenService;

    public AccountServiceImpl(AccountDao accountDao, TokenService<Account> tokenService) {
        this.accountDao = accountDao;
        this.tokenService = tokenService;
    }

    /**
     * 根据用户和密码登录
     * 判断账户密码是否一致
     *
     * @param form ...
     * @return ...
     */
    @Override
    public BaseResult<LoginResult> login(LoginForm form) {
        Account account = accountDao.selectByAccountNo(form.getAccount());
        if (Objects.isNull(account)) {
            return ResultUtils.fail("账号密码错误");
        }
        String password = passwordEncode(form.getPassword());
        if (password.equals(account.getPassword())) {
            LoginResult result = new LoginResult();
            String token = tokenService.getToken(account);
            result.setToken(token);
            return ResultUtils.success(result);
        }
        return ResultUtils.fail("账号密码错误");
    }

    /**
     * 密码加密 （MD5）
     *
     * @param password 密码-明文
     * @return 密码-密文
     */
    private String passwordEncode(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
    }
}
