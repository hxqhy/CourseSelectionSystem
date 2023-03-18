package com.wt.courseselectionsystem.model.vo.response.teacher;

import lombok.Data;

import java.util.List;

/**
 * @author lixin
 * @date 2023/3/18 16:40
 */
@Data
public class TeacherSelectListVo {
    private List<TeacherSelectListItemVo> list;
}
