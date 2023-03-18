package com.wt.courseselectionsystem.model.vo.response.course;

import lombok.Data;

import java.util.List;

/**
 * @author lixin
 * @date 2023/3/18 17:12
 */
@Data
public class CourseSelectListVo {
    private List<CourseSelectListItemVo> list;
}
