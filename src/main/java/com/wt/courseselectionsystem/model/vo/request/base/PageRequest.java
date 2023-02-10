package com.wt.courseselectionsystem.model.vo.request.base;

import lombok.Data;

/**
 * @author lixin
 */
@Data
public class PageRequest {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}
