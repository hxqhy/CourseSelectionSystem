package com.wt.courseselectionsystem.service.impl;

import com.wt.courseselectionsystem.dao.IAccountDao;
import com.wt.courseselectionsystem.model.dao.basebean.Account;
import com.wt.courseselectionsystem.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户模块 业务实现类
 * @author xxx
 */
@Service
public class AccountService implements IAccountService {
    /**
     * 注入dao层
     */
    @Autowired
    private IAccountDao accountDao;

    /**
     * 根据用户和密码登录
     * 判断账户密码是否一致
     */
    @Override
    public boolean login(String accountNo, String password) {
        Account account=accountDao.selectByAccountNo(accountNo);
        if (account!=null&&account.getPassword().equals(password)){
            return true;
        }
        return false;
    }
}
