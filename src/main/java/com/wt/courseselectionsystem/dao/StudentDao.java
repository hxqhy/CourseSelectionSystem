package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.Student;
import com.wt.courseselectionsystem.model.vo.request.student.StudentListQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lixin
 */
@Repository
public interface StudentDao {

    /**
     * 保存学生信息
     *
     * @param student student
     * @return rows
     */
    int insertStudent(@Param("student") Student student);

    /**
     * 根据账号获取用户信息
     *
     * @param studentNo 学号
     * @return ...
     */
    Student selectByStudentNo(String studentNo);
    
    /**
     * 修改学生信息
     *
     * @param student student
     * @return ...
     */
    int updateStudentInfo(@Param("student") Student student);

    /**
     * 删除学生信息
     *
     * @param studentNo ...
     * @return ...
     */
    int delete(String studentNo);

    /**
     * 查询学生详情
     *
     * @param query 条件
     * @return list
     */
    List<Student> selectStudentInfo(@Param("query") StudentListQuery query);

}
