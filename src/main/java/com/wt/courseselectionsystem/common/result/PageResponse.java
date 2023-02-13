package com.wt.courseselectionsystem.common.result;

import lombok.Data;

/**
 * @author lixin
 */
@Data
public class PageResponse {

    /**
     * 当前页码
     */
    private Integer pageNum;

    /**
     * 页容量
     */
    private Integer pageSize;

    /**
     * 总页数
     * total page
     */
    private Integer pages;
}
