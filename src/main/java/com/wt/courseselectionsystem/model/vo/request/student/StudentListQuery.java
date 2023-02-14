package com.wt.courseselectionsystem.model.vo.request.student;

import com.wt.courseselectionsystem.model.vo.request.base.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lixin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class StudentListQuery extends PageRequest {

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
