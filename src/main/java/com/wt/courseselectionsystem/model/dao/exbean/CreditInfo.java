package com.wt.courseselectionsystem.model.dao.exbean;

import lombok.Data;

@Data
public class CreditInfo {
    private String studentName;
    private String studentNo;
    private String studentClass;
    /**
     * 学分总和
     */
    private Integer totalCredits;
}