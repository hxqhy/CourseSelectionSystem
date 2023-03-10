package com.wt.courseselectionsystem.config.interceptor;

import com.wt.courseselectionsystem.common.annotation.LoginRequired;
import com.wt.courseselectionsystem.model.dao.basebean.Account;
import com.wt.courseselectionsystem.service.TokenService;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author lixin
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    private final TokenService<Account> tokenService;

    public AuthenticationInterceptor(
            TokenService<Account> tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        Method method = ((HandlerMethod) handler).getMethod();
        Class<?> clazz = method.getDeclaringClass();
        boolean classAnnotation = clazz.isAnnotationPresent(LoginRequired.class);
        boolean methodAnnotation = method.isAnnotationPresent(LoginRequired.class);
        // 如果 类 和 方法 上都没有 LoginRequired 直接通过
        if (!classAnnotation && !methodAnnotation) {
            return true;
        }

        LoginRequired loginRequired = (methodAnnotation ? method : clazz).getAnnotation(LoginRequired.class);

        if (!loginRequired.required()) {
            return true;
        }

        String token = Optional.ofNullable(request.getHeader("token"))
                .orElseThrow(() -> new RuntimeException("Login required."));

        Optional.of(tokenService.getData(token))
                .map(account -> {
                    Integer role = account.getAccountType();
                    List<Integer> roleList = Arrays.stream(loginRequired.role()).boxed()
                            .collect(Collectors.toList());
                    if (roleList.contains(role)) {
                        return true;
                    } else {
                        throw new RuntimeException("禁止访问");
                    }
                });
        return true;
    }
}
