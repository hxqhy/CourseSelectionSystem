package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.data.StudentTestData;
import com.wt.courseselectionsystem.model.dao.basebean.Student;
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
        StudentTestData testData = new StudentTestData();
        Student student = testData.generateStudent();
        System.out.println(studentDao.insertStudent(student) == 1);
    }
}
