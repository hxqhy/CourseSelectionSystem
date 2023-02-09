package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.entity.Account;
import org.springframework.stereotype.Repository;

/**
 * @author lixin
 */
@Repository
public interface AccountDao {
    //根据账号获取用户信息
    public Account selectById(String id);
}
