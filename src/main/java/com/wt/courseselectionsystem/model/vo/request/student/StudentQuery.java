package com.wt.courseselectionsystem.model.vo.request.student;

import com.wt.courseselectionsystem.model.vo.request.base.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lixin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class StudentQuery extends PageRequest {
    private Integer gender;
    private String studentClass;
    //todo 通过姓名模糊查询
    /**
     * 是否处于激活状态，激活：1，未激活：0；
     */
    private Integer active;
}
