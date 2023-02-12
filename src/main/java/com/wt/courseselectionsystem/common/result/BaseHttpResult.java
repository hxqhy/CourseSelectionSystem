package com.wt.courseselectionsystem.common.result;

import lombok.Data;

/**
 * @author lixin
 */
@Data
public abstract class BaseHttpResult<T> {

    private Integer code;
    private String msg;

    /**
     * 设置数据
     *
     * @param data data
     */
    abstract public void setData(T data);
}
