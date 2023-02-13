package com.wt.courseselectionsystem.model.vo.request.teacher;

import com.wt.courseselectionsystem.model.vo.request.base.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xxx
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TeacherQuery extends PageRequest {
    private Integer gender;

    private String teacherName;
    /**
     * 是否处于激活状态，激活：1，未激活：0；
     */
    private Integer active;
}
