package com.wt.courseselectionsystem.config;

import com.wt.courseselectionsystem.common.ResultUtils;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author lixin
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public NoDataResult runtimeExceptionHandler(RuntimeException e) {
        log.error("GlobalExceptionHandler.runtimeExceptionHandler:" + e.getMessage(), e);
        return ResultUtils.fail(e.getMessage());
    }

}
