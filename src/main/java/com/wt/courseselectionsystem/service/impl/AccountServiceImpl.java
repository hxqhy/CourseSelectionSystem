package com.wt.courseselectionsystem.service.impl;

import com.wt.courseselectionsystem.common.SystemUtils;
import com.wt.courseselectionsystem.dao.AccountDao;
import com.wt.courseselectionsystem.model.dao.basebean.Account;
import com.wt.courseselectionsystem.model.vo.request.LoginForm;
import com.wt.courseselectionsystem.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 用户模块 业务实现类
 *
 * @author xxx
 */
@Service
public class AccountServiceImpl implements AccountService {

    /**
     * 注入dao层
     */
    private final AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 根据用户和密码登录
     * 判断账户密码是否一致
     *
     * @param form ...
     */
    @Override
    public boolean login(LoginForm form) {
        Account account = accountDao.selectByAccountNo(form.getAccount());
        if (Objects.isNull(account)) {
            throw new RuntimeException("用户不存在");
        }
        String password = SystemUtils.encode(form.getPassword());
        // todo: 登陆验证成功 颁发token
        return password.equals(account.getPassword());
    }
}
