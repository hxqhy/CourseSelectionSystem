package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.Teacher;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherListQuery;
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

    /**
     * 查询教师详情
     *
     * @param query 条件
     * @return list
     */
    List<Teacher> selectTeacherInfo(@Param("query") TeacherListQuery query);

    /**
     * selectMatchListByTeacherNo
     *
     * @param teacherNo ...
     * @return java.util.List<com.wt.courseselectionsystem.model.dao.basebean.Teacher>
     * @date 2023/3/18 16:53
     **/
    List<Teacher> selectMatchListByTeacherNo(@Param("teacherNo") String teacherNo);
}
