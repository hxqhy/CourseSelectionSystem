package com.wt.courseselectionsystem.model.vo.response;

import com.wt.courseselectionsystem.common.result.PageResponse;
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
