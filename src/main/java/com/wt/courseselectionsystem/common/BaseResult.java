package com.wt.courseselectionsystem.common;

import lombok.Data;

/**
 * @author lixin
 */
@Data
public class BaseResult<T> {
    private Integer code;
    private String msg;
    private T data;
}
