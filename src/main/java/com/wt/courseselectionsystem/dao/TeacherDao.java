package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.Teacher;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xxx
 */
@Repository
public interface TeacherDao {

    /**
     * 保存教师信息
     *
     * @param teacher teacher
     * @return ...
     */
    int insertTeacher(@Param("teacher") Teacher teacher);

    /**
     * 根据账号获取用户信息
     *
     * @param teacherNo 教师账号
     * @return ...
     */
    Teacher selectByTeacherNo(String teacherNo);

    /**
     * 教师表条件查询列表
     *
     * @param query ...
     * @return ...
     */
    List<Teacher> select(@Param("query") TeacherQuery query);

    /**
     * 修改教师信息
     *
     * @param teacher teacher
     * @return ...
     */
    int updateTeacherInfo(@Param("teacher") Teacher teacher);

    /**
     * 删除教师信息
     *
     * @param teacherNo ...
     * @return ...
     */
    int delete(String teacherNo);
}
