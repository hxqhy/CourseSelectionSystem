package com.wt.courseselectionsystem.common.annotation;

import com.wt.courseselectionsystem.common.annotation.limiter.Limiter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 根据用户限制接口能力
 *
 * @author lixin
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LimitAbility {

    /**
     * 限制器
     *
     * @return ...
     */
    Class<? extends Limiter> value();
}
