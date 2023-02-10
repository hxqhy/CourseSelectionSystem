package com.wt.courseselectionsystem.common;

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

}
