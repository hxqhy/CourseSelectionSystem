package com.wt.courseselectionsystem.model.vo.request;

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
}
