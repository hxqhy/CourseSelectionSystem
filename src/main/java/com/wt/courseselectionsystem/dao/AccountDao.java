package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lixin
 */
@Repository
public interface AccountDao {

    /**
     * 根据账号获取用户信息
     *
     * @param accountNo 学号
     * @return ...
     */
    Account selectByAccountNo(String accountNo);

    /**
     * 保存账号信息
     *
     * @param account account
     * @return row
     */
    int insertAccount(Account account);

    /**
     * 保存账号信息
     *
     * @param accounts accounts
     * @return row
     */
    int insertAccountList(@Param("accounts") List<Account> accounts);

    /**
     * 激活学生账号
     *
     * @param studentNo studentNo
     * @param password  password
     * @return row
     */
    int activateStudentAccount(@Param("studentNo") String studentNo, @Param("password") String password);

    /**
     * 激活导师账号
     *
     * @param teacherNo teacherNo
     * @param password  password
     * @return row
     */
    int activateTeacherAccount(@Param("teacherNo") String teacherNo, @Param("password") String password);

    /**
     * 批量激活学生账号
     *
     * @param studentNoList 学生账号集合
     * @param password      password
     * @return row
     */
    int activateStudentList(@Param("studentNoList") List<String> studentNoList, @Param("password") String password);

    /**
     * 批量激活导师账号
     *
     * @param teacherNoList 导师账号集合
     * @param password      password
     * @return row
     */
    int activateTeacherList(@Param("teacherNoList") List<String> teacherNoList, @Param("password") String password);
}
