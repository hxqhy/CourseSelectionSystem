package com.wt.courseselectionsystem.model.dao.exbean;

import lombok.Data;

/**
 * 教师实体类
 *
 * @author xxx
 */
@Data
public class TeacherInfo {
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
