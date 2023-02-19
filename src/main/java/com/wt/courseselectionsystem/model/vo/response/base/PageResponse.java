package com.wt.courseselectionsystem.model.vo.response.base;

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

    /**
     * 总量
     */
    private Long total;
}
