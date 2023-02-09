package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.model.vo.request.LoginForm;

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
    boolean login(LoginForm form);

}
