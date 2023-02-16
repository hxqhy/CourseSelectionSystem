package com.wt.courseselectionsystem.model.vo.response;

import com.wt.courseselectionsystem.common.result.PageResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author lixin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class StudentsOfCoursePlanVo extends PageResponse {
    private List<StudentVo> list;
}
