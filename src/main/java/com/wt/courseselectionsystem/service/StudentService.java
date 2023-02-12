package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.model.vo.request.student.StudentAddForm;
import com.wt.courseselectionsystem.model.vo.request.student.StudentQuery;
import com.wt.courseselectionsystem.model.vo.request.student.StudentUpdateForm;
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
    DataResult<List<StudentVo>> list(StudentQuery query);

    /**
     * 修改学生信息
     *
     * @param form ...
     * @return ...
     */
    NoDataResult update(StudentUpdateForm form);

    /**
     * 增加学生
     *
     * @param form ...
     * @return ...
     */
    NoDataResult addStudent(StudentAddForm form);

    /**
     * 查询单个学生的信息
     *
     * @param studentNo ...
     * @return ...
     */
    DataResult<StudentVo> info(String studentNo);

    /**
     * 删除学生信息
     *
     * @param studentNo ...
     * @return ...
     */
    NoDataResult delete(String studentNo);
}
