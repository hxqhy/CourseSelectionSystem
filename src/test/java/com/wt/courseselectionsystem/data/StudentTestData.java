package com.wt.courseselectionsystem.data;

import com.wt.courseselectionsystem.model.dao.basebean.Student;
import com.wt.courseselectionsystem.utils.StudentBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lixin
 */
@SpringBootTest
public class StudentTestData {

    @Test
    public void students() {
        StudentBuilder builder = new StudentBuilder();
        Student student = builder.generateStudent();
        System.out.println(student);
    }
}
