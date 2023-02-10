package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.Student;
import com.wt.courseselectionsystem.model.vo.request.StudentQuery;
import com.wt.courseselectionsystem.utils.StudentBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lixin
 */
@SpringBootTest
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void testInsertStudent() {
        StudentBuilder builder = new StudentBuilder();
        Student student = builder.generateStudent();
        System.out.println(studentDao.insertStudent(student) == 1);
    }

    @Test
    public void testSelectStudentByStudentNo() {
        System.out.println(studentDao.selectByStudentNo("202040823585"));
    }

    @Test
    public void testSelect() {
        StudentQuery query = new StudentQuery();
        query.setActive(1);
        System.out.println(studentDao.select(query));
    }
}
