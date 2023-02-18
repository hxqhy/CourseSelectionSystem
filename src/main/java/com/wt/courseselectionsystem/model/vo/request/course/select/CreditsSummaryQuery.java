package com.wt.courseselectionsystem.model.vo.request.course.select;

/**
 * @author lixin
 */
public class CreditsSummaryQuery {
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
}
