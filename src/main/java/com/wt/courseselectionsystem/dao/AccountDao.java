package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lixin
 */
@Repository
public interface AccountDao {

    /**
     * 根据账号获取用户信息
     *
     * @param accountNo 学号
     * @return ...
     */
    Account selectByAccountNo(String accountNo);

    /**
     * 保存账号信息
     *
     * @param account account
     * @return row
     */
    int insertAccount(Account account);

    /**
     * 批量激活账号
     *
     * @param accounts accounts
     * @return row
     */
    int insertAccountList(@Param("accounts") List<Account> accounts);
}
