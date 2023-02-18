package com.wt.courseselectionsystem.model.vo.response.course.select;

import com.wt.courseselectionsystem.common.result.PageResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author lixin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CourseSelectionSituationListVo extends PageResponse {

    private List<CourseSelectionSituationVo> list;

}
