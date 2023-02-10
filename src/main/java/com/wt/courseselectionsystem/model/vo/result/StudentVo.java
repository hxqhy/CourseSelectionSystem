package com.wt.courseselectionsystem.model.vo.result;

import lombok.Data;

/**
 * @author lixin
 */
@Data
public class StudentVo {

    /**
     * 学生学号
     */
    private String studentNo;
    /**
     * 学生名称
     */
    private String studentName;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 班级
     */
    private String studentClass;
}
