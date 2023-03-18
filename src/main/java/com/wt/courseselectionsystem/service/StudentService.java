package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.model.vo.request.student.StudentAddForm;
import com.wt.courseselectionsystem.model.vo.request.student.StudentListQuery;
import com.wt.courseselectionsystem.model.vo.request.student.StudentUpdateForm;
import com.wt.courseselectionsystem.model.vo.response.student.StudentListVo;
import com.wt.courseselectionsystem.model.vo.response.student.StudentSelectListVo;
import com.wt.courseselectionsystem.model.vo.response.student.StudentVo;

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
    DataResult<StudentListVo> list(StudentListQuery query);

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

    /**
     * selectionList
     *
     * @param studentNo ...
     * @return com.wt.courseselectionsystem.common.result.DataResult<com.wt.courseselectionsystem.model.vo.response.student.StudentSelectListVo>
     * @date 2023/3/18 17:23
     **/
    DataResult<StudentSelectListVo> selectionList(String studentNo);
}
