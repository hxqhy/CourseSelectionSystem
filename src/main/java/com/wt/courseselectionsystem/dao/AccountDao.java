package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.Account;
import org.springframework.stereotype.Repository;

/**
 * @author lixin
 */
@Repository
public interface AccountDao {

    /**
     * 根据账号获取用户信息
     *
     * @param id id
     * @return ...
     */
    Account selectById(String id);
}
