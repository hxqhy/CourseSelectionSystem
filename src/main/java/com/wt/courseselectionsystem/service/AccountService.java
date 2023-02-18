package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.model.vo.request.LoginForm;
import com.wt.courseselectionsystem.model.vo.request.account.*;
import com.wt.courseselectionsystem.model.vo.response.AccountVo;
import com.wt.courseselectionsystem.model.vo.response.LoginResult;

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
     * @param form ...
     * @return ...
     */
    NoDataResult activateStudentAccount(ActivateSingleAccountForm form);

    /**
     * 激活导师账号
     *
     * @param form ...
     * @return ...
     */
    NoDataResult activateTeacherAccount(ActivateSingleAccountForm form);

    /**
     * 批量激活学生账号
     *
     * @param activeStudentForm ...
     * @return ...
     */
    NoDataResult activateStudentList(ActiveStudentForm activeStudentForm);

    /**
     * 批量激活导师账号
     *
     * @param activateTeacherForm ...
     * @return ...
     */
    NoDataResult activateTeacherList(ActivateTeacherForm activateTeacherForm);

    /**
     * 修改密码
     *
     * @param passwordForm ...
     * @return ...
     */
    NoDataResult updatePassword(UpdatePasswordForm passwordForm);

    /**
     * 批量激活所有学生
     *
     * @return ...
     */
    NoDataResult activateAllStudents();

    /**
     * 批量激活所有教师
     *
     * @return ...
     */
    NoDataResult activateAllTeacher();

    /**
     * 重置密码
     *
     * @param resetForm ...
     * @return ...
     */
    NoDataResult resetPassword(ResetPasswordForm resetForm);
}
