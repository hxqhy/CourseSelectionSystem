package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.common.constant.AccountConstant;
import com.wt.courseselectionsystem.model.dao.basebean.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.wt.courseselectionsystem.common.SystemUtils.passwordEncode;

/**
 * @author lixin
 */
@SpringBootTest
public class AccountDaoTest {

    @Autowired
    private AccountDao accountDao;

    @Test
    public void testInsertAccount() {
        Account account = new Account();
        account.setAccountNo("admin");
        account.setPassword(passwordEncode("admin"));
        account.setAccountType(AccountConstant.ADMIN_CODE);
        System.out.println(accountDao.insertAccount(account) == 1);
    }

    @Test
    public void testSelectAccountByAccountNo() {
        System.out.println(accountDao.selectByAccountNo("201948178305"));
    }
}

