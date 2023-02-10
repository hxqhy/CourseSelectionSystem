package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.model.vo.request.StudentQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lixin
 */
@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentService service;

    @Test
    public void testStudentQuery() {
        StudentQuery query = new StudentQuery();
        System.out.println(service.query(query).getData().size());
    }
}
