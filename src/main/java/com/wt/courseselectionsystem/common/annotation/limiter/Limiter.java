package com.wt.courseselectionsystem.common.annotation.limiter;

import com.wt.courseselectionsystem.model.dao.basebean.Account;

/**
 * 限制器
 *
 * @author lixin
 */
public interface Limiter {

    /**
     * 限制
     *
     * @param ability ...
     * @param account account
     * @return 被限制后的 ..
     */
    Object limit(Object ability, Account account);

    Limiter USELESS_LIMITER = new UselessLimiter();
}
