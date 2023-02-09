package com.wt.courseselectionsystem.model.dao.basebean;

import lombok.Data;

/**
 * 学生实体类
 *  @author xxx
 */
@Data
public class Student {
    /**
     * 学生id
     */
    private String id;
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
    private char gender;
    /**
     * 班级
     */
    private String studentClass;

   }
