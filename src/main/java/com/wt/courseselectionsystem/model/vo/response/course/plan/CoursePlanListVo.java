package com.wt.courseselectionsystem.model.vo.response.course.plan;

import com.wt.courseselectionsystem.model.vo.response.base.PageResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author lixin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CoursePlanListVo extends PageResponse {

    private List<CoursePlanVo> list;
}
