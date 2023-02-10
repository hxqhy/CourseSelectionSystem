package com.wt.courseselectionsystem.common.result;

/**
 * @author lixin
 */
public class NoDataResult extends HttpResult<Object> {

    @Override
    public void setData(Object data) {
        throw new UnsupportedOperationException();
    }
}
