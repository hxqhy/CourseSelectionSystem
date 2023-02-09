package com.wt.courseselectionsystem.common;

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

    public static <T> BaseResult<T> success() {
        return build(DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MSG, null);
    }

    public static <T> BaseResult<T> fail(String msg) {
        return build(DEFAULT_FAIL_CODE, msg, null);
    }

    public static <T> BaseResult<T> success(T data) {
        return build(DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MSG, data);
    }

    public static <T> BaseResult<T> fail(T data) {
        return build(DEFAULT_FAIL_CODE, DEFAULT_FAIL_MSG, data);
    }

    public static <T> BaseResult<T> success(String msg, T data) {
        return build(DEFAULT_SUCCESS_CODE, msg, data);

    }

    public static <T> BaseResult<T> fail(String msg, T data) {
        return build(DEFAULT_FAIL_CODE, msg, data);
    }

    private static <T> BaseResult<T> build(int code, String msg, T data) {
        BaseResult<T> result = new BaseResult<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
