package com.wt.courseselectionsystem.model.vo.response.course.select;

import com.wt.courseselectionsystem.common.constant.CourseSelectionConstant;
import com.wt.courseselectionsystem.model.vo.response.base.PageResponse;
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

    /**
     * 学分标准
     */
    private Integer creditStandard = CourseSelectionConstant.CREDIT_STANDARD;

}
