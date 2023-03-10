package com.wt.courseselectionsystem.common.constant;

/**
 * 账户相关常量
 *
 * @author lixin
 */
public final class AccountConstant {

    private AccountConstant() {
    }

    /**
     * 管理员账户类型code
     */
    public static final int ADMIN_CODE = 0;

    /**
     * 学生账户类型code
     */
    public static final int STUDENT_CODE = 1;

    /**
     * 教师账户类型code
     */
    public static final int TEACHER_CODE = 2;

    /**
     * 学生账号前缀
     */
    public static final String STUDENT_PREFIX = "S";

    /**
     * 教师账号前缀
     */
    public static final String TEACHER_PREFIX = "T";

    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD = "123456";

    /**
     * 查询学生或老师是否处于激活状态
     */
    public static final Integer QUERY_ACTIVE_CODE_IS_ACTIVE = 1;

    /**
     * 查询学生或老师是否处于未激活状态
     */
    public static final Integer QUERY_ACTIVE_CODE_IS_NO_ACTIVE = 0;

}

