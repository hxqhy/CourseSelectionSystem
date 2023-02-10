package com.wt.courseselectionsystem.data;

import com.wt.courseselectionsystem.dao.StudentDao;
import com.wt.courseselectionsystem.model.dao.basebean.Student;
import com.wt.courseselectionsystem.utils.StudentBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lixin
 */
@SpringBootTest
public class StudentTestData {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void students() {
        StudentBuilder builder = new StudentBuilder();
        for (int i = 0; i < 100; i++) {
            Student student = builder.generateStudent();
            try {
                studentDao.insertStudent(student);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
