package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.common.BaseResult;
import com.wt.courseselectionsystem.model.vo.request.LoginForm;
import com.wt.courseselectionsystem.model.vo.result.AccountVo;
import com.wt.courseselectionsystem.model.vo.result.LoginResult;

/**
 * 用户模块 业务接口
 *
 * @author xxx
 */
public interface AccountService {

    /**
     * 用户登录
     *
     * @param form ...
     * @return ...
     */
    BaseResult<LoginResult> login(LoginForm form);

    /**
     * 通过token获取用户信息
     *
     * @param token token
     * @return account info
     */
    BaseResult<AccountVo> getAccountInfo(String token);

    /**
     * 激活学生账号
     *
     * @param accountNo 学号
     * @return ...
     */
    BaseResult<Object> activationStudentAccount(String accountNo);

}
