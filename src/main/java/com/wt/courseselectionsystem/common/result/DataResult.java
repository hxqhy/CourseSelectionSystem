package com.wt.courseselectionsystem.common.result;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lixin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DataResult<T> extends BaseHttpResult<T> {

    private T data;

    @Override
    public void setData(T data) {
        this.data = data;
    }

}
