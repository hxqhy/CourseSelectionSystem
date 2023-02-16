package com.wt.courseselectionsystem.common.annotation.limiter;

import com.wt.courseselectionsystem.model.dao.basebean.Account;

/**
 * @author lixin
 */
public class UselessLimiter implements Limiter {

    UselessLimiter() {
    }

    @Override
    public Object limit(Object ability, Account account) {
        return ability;
    }

}
