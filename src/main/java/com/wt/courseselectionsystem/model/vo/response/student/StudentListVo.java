package com.wt.courseselectionsystem.model.vo.response.student;

import com.wt.courseselectionsystem.model.vo.response.base.PageResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author HY
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class StudentListVo extends PageResponse {
    private List<StudentVo> list;
}
