package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherAddForm;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherListQuery;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherQuery;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherUpdateForm;
import com.wt.courseselectionsystem.model.vo.response.TeacherListVo;
import com.wt.courseselectionsystem.model.vo.response.TeacherVo;

import java.util.List;

/**
 * @author HY
 */
public interface TeacherService {
    /**
     * 添加教师
     *
     * @param form ...
     * @return ...
     */
    NoDataResult addTeacher(TeacherAddForm form);

    /**
     * 条件查询教师信息列表
     *
     * @param query ...
     * @return ...
     */
    DataResult<TeacherListVo> list(TeacherListQuery query);

    /**
     * 修改教师信息列表
     *
     * @param form ...
     * @return ...
     */
    NoDataResult update(TeacherUpdateForm form);

    /**
     * 查询单个教师信息
     *
     * @param teacherNo ...
     * @return ...
     */
    DataResult<TeacherVo> info(String teacherNo);

    /**
     * 删除教师信息
     *
     * @param teacherNo ...
     * @return ...
     */
    NoDataResult delete(String teacherNo);
}
