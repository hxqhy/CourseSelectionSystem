package com.wt.courseselectionsystem.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wt.courseselectionsystem.common.annotation.LimitAbility;
import com.wt.courseselectionsystem.common.annotation.limiter.Limiter;
import com.wt.courseselectionsystem.model.dao.basebean.Account;
import com.wt.courseselectionsystem.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

/**
 * @author lixin
 */
@Component
@Slf4j
public class LimitAbilityMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private final TokenService<Account> tokenService;

    public LimitAbilityMethodArgumentResolver(TokenService<Account> tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Objects.requireNonNull(parameter.getMethod()).isAnnotationPresent(LimitAbility.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        HttpServletRequest request = Optional.ofNullable(webRequest.getNativeRequest(HttpServletRequest.class))
                .orElseThrow(() -> new RuntimeException("获取HttpServletRequest对象失败！"));
        Optional<Limiter> limiterOptional = Optional.ofNullable(parameter.getMethod())
                .filter(method -> method.isAnnotationPresent(LimitAbility.class))
                .map(method -> method.getAnnotation(LimitAbility.class))
                .map(LimitAbility::value)
                .map(clazz -> {
                    try {
                        return clazz.newInstance();
                    } catch (InstantiationException | IllegalAccessException e) {
                        log.error(e.getMessage(), e);
                        throw new RuntimeException("服务器异常");
                    }
                });
        final String token = request.getHeader("token");
        final Account account = tokenService.getData(token);
        Limiter limiter = limiterOptional.orElse(Limiter.USELESS_LIMITER);
        final Class<?> type = parameter.getParameterType();
        final String get = "GET";
        final String post = "POST";
        Object o;
        switch (request.getMethod()) {
            case get:
                o = request.getParameter(parameter.getParameterName());
                break;
            case post:
                o = jsonToObj(paresRequestBody(request), type);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + request.getMethod());
        }
        return limiter.limit(o, account);
    }

    private Object jsonToObj(String json, Class<?> type) {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, type);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    private String paresRequestBody(HttpServletRequest request) {
        final StringBuilder builder = new StringBuilder();
        final BufferedReader reader;
        String line;
        try {
            reader = request.getReader();
            while (!Objects.isNull((line = reader.readLine()))) {
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

}