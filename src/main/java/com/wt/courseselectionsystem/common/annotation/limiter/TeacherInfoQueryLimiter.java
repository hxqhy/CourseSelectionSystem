package com.wt.courseselectionsystem.common.annotation.limiter;

import com.wt.courseselectionsystem.common.SystemUtils;
import com.wt.courseselectionsystem.model.dao.basebean.Account;

import java.util.Optional;

import static com.wt.courseselectionsystem.common.constant.AccountConstant.TEACHER_CODE;

/**
 * @author hy
 */
public class TeacherInfoQueryLimiter implements Limiter {

    @Override
    public Object limit(Object ability, Account account) {
        Integer accountType = Optional.ofNullable(account)
                .map(Account::getAccountType)
                .orElseThrow(() -> new RuntimeException("获取账户类型失败"));
        return accountType.equals(TEACHER_CODE)
                ? SystemUtils.parseAccountNo(account.getAccountNo()) : ability;
    }

}
