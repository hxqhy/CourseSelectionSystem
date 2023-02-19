package com.wt.courseselectionsystem.model.vo.response.course;

import com.wt.courseselectionsystem.model.vo.response.base.PageResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author HY
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CourseListVo extends PageResponse {
    private List<CourseVo> list;
}
