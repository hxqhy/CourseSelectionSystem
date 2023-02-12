package com.wt.courseselectionsystem.model.vo.request.student;

import lombok.Data;

/**
 * @author lixin
 */
@Data
public class StudentAddForm {

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
