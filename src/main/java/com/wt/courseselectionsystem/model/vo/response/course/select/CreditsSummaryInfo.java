package com.wt.courseselectionsystem.model.vo.response.course.select;

import lombok.Data;

/**
 * @author lixin
 */
@Data
public class CreditsSummaryInfo {
    private String studentName;
    private String studentNo;
    private String studentClass;
    /**
     * 学分总和
     */
    private Integer totalCredits;
}
