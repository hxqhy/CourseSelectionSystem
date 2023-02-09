package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
    
}
