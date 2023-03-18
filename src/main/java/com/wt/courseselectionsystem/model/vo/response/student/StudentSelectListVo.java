package com.wt.courseselectionsystem.model.vo.response.student;

import lombok.Data;

import java.util.List;

/**
 * @author lixin
 * @date 2023/3/18 17:20
 */
@Data
public class StudentSelectListVo {
    private List<StudentSelectListItemVo> list;
}
