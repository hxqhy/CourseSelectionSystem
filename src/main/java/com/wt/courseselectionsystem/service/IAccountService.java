package com.wt.courseselectionsystem.service;
/**
 * 用户模块 业务接口
 * @author xxx
 */
public interface IAccountService {
    /**
     *用户登录
      */
    public boolean login(String accountNo,String password);

}
