package com.wt.courseselectionsystem.model.dao.basebean;

import lombok.Data;

/**
 * 教师实体类
 *  @author xxx
 */
@Data
public class Teacher {
    /**
     * 教师id
     */
    private String id;
    /**
     * 教师编号
     */
    private String teacherNo;
    /**
     * 教师名称
     */
    private String teacherName;
    /**
     * 性别
     */
    private Integer gender;

}
