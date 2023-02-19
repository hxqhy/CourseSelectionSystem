package com.wt.courseselectionsystem.model.vo.request.course.select;

import com.wt.courseselectionsystem.model.vo.request.base.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lixin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CreditsSummaryQuery extends PageRequest {
    /**
     * 学分
     */
    private Integer credits;

    /**
     * 比较方式
     * <p>
     * -1：总学分低于 {@link CreditsSummaryQuery#credits}
     * <br>
     * 0：总学分等于 {@link CreditsSummaryQuery#credits}
     * <br>
     * 1：总学分高于 {@link CreditsSummaryQuery#credits}
     */
    private Integer comparison;

    private String studentNo;

    private String studentName;
}
