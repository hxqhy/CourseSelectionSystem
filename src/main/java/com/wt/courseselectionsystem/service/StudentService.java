package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
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
    DataResult<List<StudentVo>> list(StudentQuery query);

    /**
     * 修改学生信息
     *
     * @param studentVo ...
     * @return ...
     */
    NoDataResult update(StudentVo studentVo);

    /**
     * 增加学生
     *
     * @param studentVo ...
     * @return ...
     */
    NoDataResult addStudent(StudentVo studentVo);

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
