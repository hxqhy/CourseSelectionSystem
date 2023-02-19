package com.wt.courseselectionsystem.model.vo.request.base;

import lombok.Data;

/**
 * @author lixin
 */
@Data
public class PageRequest {
    /**
     * 页码
     */
    private Integer pageNum = 1;
    /**
     * 页大小
     */
    private Integer pageSize = 10;
}
