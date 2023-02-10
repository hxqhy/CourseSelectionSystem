package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
}
