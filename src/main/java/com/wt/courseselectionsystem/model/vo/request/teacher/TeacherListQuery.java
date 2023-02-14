package com.wt.courseselectionsystem.model.vo.request.teacher;

import com.wt.courseselectionsystem.model.vo.request.base.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xxx
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TeacherListQuery extends PageRequest {
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
