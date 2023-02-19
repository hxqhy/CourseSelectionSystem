package com.wt.courseselectionsystem.model.vo.response.course.select;

import com.wt.courseselectionsystem.common.result.PageResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author lixin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CreditsSummaryListVo extends PageResponse {
    private List<CreditsSummaryInfo> list;
}
