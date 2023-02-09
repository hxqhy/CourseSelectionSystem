package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.Account;
import org.springframework.stereotype.Repository;

/**
 * @author lixin
 */
@Repository
public interface IAccountDao {
    /**根据账号获取用户信息*/
    public Account selectByAccountNo(String accountNo);
}
