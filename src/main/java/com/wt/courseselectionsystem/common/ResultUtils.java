package com.wt.courseselectionsystem.common;

import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;

/**
 * @author lixin
 */
public final class ResultUtils {

    private ResultUtils() {
    }

    private static final int DEFAULT_SUCCESS_CODE = 200;
    private static final int DEFAULT_FAIL_CODE = 400;
    private static final String DEFAULT_SUCCESS_MSG = "success";
    private static final String DEFAULT_FAIL_MSG = "error";

    public static NoDataResult success() {
        return buildNoDataResult(DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MSG);
    }

    public static NoDataResult success(String msg) {
        return buildNoDataResult(DEFAULT_SUCCESS_CODE, msg);
    }

    public static NoDataResult fail(String msg) {
        return buildNoDataResult(DEFAULT_FAIL_CODE, msg);
    }

    public static <T> DataResult<T> success(T data) {
        return build(DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MSG, data);
    }

    public static <T> DataResult<T> success(String msg, T data) {
        return build(DEFAULT_SUCCESS_CODE, msg, data);

    }

    public static <T> DataResult<T> fail(String msg, T data) {
        return build(DEFAULT_FAIL_CODE, msg, data);
    }

    private static <T> DataResult<T> build(int code, String msg, T data) {
        DataResult<T> result = new DataResult<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    private static NoDataResult buildNoDataResult(int code, String msg) {
        NoDataResult result = new NoDataResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
