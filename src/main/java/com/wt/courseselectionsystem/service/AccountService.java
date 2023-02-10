package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
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
    DataResult<LoginResult> login(LoginForm form);

    /**
     * 通过token获取用户信息
     *
     * @param token token
     * @return account info
     */
    DataResult<AccountVo> getAccountInfo(String token);

    /**
     * 激活学生账号
     *
     * @param studentNo 学号
     * @return ...
     */
    NoDataResult activateStudentAccount(String studentNo);

}
