package com.wt.courseselectionsystem.service.impl;

import com.wt.courseselectionsystem.common.ResultUtils;
import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.dao.AccountDao;
import com.wt.courseselectionsystem.model.dao.basebean.Account;
import com.wt.courseselectionsystem.model.vo.request.LoginForm;
import com.wt.courseselectionsystem.model.vo.result.AccountVo;
import com.wt.courseselectionsystem.model.vo.result.LoginResult;
import com.wt.courseselectionsystem.service.AccountService;
import com.wt.courseselectionsystem.service.TokenService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.wt.courseselectionsystem.common.SystemUtils.passwordEncode;

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
    public NoDataResult activationStudentAccount(String accountNo) {
        return null;
    }

}
