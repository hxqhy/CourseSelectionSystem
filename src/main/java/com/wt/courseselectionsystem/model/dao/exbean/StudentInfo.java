package com.wt.courseselectionsystem.model.dao.exbean;

import lombok.Data;

/**
 * 学生实体类
 *
 * @author xxx
 */
@Data
public class StudentInfo {
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
