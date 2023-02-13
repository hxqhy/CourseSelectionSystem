package com.wt.courseselectionsystem.common;

import com.github.pagehelper.PageInfo;
import com.wt.courseselectionsystem.common.constant.AccountConstant;
import com.wt.courseselectionsystem.common.result.PageResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lixin
 */
public final class SystemUtils {

    private SystemUtils() {
    }

    /**
     * 密码加密 （MD5）
     *
     * @param password 密码-明文
     * @return 密码-密文
     */
    public static String passwordEncode(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
    }


    /**
     * 列表拷贝
     *
     * @param list  数据源
     * @param clazz 目标对象 class
     * @param <T>   目标对象 type
     * @return list
     */
    public static <T> List<T> easyCopy(List<?> list, Class<T> clazz) {
        List<T> result = Collections.emptyList();
        if (!CollectionUtils.isEmpty(list)) {
            result = list.stream().map(item -> {
                try {
                    T o = clazz.newInstance();
                    BeanUtils.copyProperties(item, o);
                    return o;
                } catch (InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());
        }
        return result;
    }

    /**
     * 配置返回值分页信息
     *
     * @param response response
     * @param pageInfo pageInfo
     */
    public static void configPageInfo(PageResponse response, PageInfo<?> pageInfo) {
        response.setPageNum(pageInfo.getPageNum());
        response.setPageSize(pageInfo.getPageSize());
        response.setPages(pageInfo.getPages());
    }

    /**
     * 通过学生编号生成账号
     *
     * @param studentNo 学号
     * @return accountNo
     */
    public static String generateStudentAccountNo(String studentNo) {
        return AccountConstant.STUDENT_PREFIX + studentNo;
    }

    /**
     * 将常量转换为mybatis xml能够使用的常量
     * S -> 'S'
     *
     * @param constant ...
     * @return ...
     */
    @SuppressWarnings("unused")
    public static String xmlConstant(String constant) {
        return String.format("'%s'", constant);
    }

}
