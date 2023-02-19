package com.wt.courseselectionsystem.model.vo.response.teacher;

import com.wt.courseselectionsystem.model.vo.response.base.PageResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author HY
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TeacherListVo extends PageResponse {
    private List<TeacherVo> list;
}
