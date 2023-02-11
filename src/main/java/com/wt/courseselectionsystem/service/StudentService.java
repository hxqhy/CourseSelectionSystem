package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.model.vo.request.StudentQuery;
import com.wt.courseselectionsystem.model.vo.response.StudentVo;

import java.util.List;

/**
 * @author lixin
 */
public interface StudentService {

    /**
     * 条件查询学生信息列表
     *
     * @param query ...
     * @return ...
     */
    DataResult<List<StudentVo>> query(StudentQuery query);
}
