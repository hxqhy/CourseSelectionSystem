package com.wt.courseselectionsystem.model.vo.request.teacher;

import lombok.Data;

/**
 * @author xxx
 */
@Data
public class TeacherAddForm {
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
