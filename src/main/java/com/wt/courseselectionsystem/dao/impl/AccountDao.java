package com.wt.courseselectionsystem.dao.impl;

import com.wt.courseselectionsystem.dao.IAccountDao;
import com.wt.courseselectionsystem.model.dao.basebean.Account;
import org.apache.ibatis.jdbc.SQL;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * 持久层实现类
 * @author xxx
 */
@Repository
public class AccountDao extends SqlSessionDaoSupport implements IAccountDao {

    private static final String SQL_NAMESPACE="Account";
    @Override
    /**
     * 根据账户获取信息
     * @Param accountNo
     * @return
     */
    public Account selectByAccountNo(String accountNo) {
        Map<String,String> map=new HashMap<String,String>();
        map.put("accountNo",accountNo);
        return this.getSqlSession().selectOne(SQL_NAMESPACE+".selectByAccountNo",map);
    }
}
