package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.model.dao.basebean.Student;
import com.wt.courseselectionsystem.model.vo.request.student.StudentAddForm;
import com.wt.courseselectionsystem.model.vo.request.student.StudentQuery;
import com.wt.courseselectionsystem.model.vo.request.student.StudentUpdateForm;
import com.wt.courseselectionsystem.utils.StudentBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
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
        System.out.println(service.list(query).getData().size());
    }

    @Test
    public void updateStudentInfo() {
        StudentUpdateForm form = new StudentUpdateForm();
        form.setStudentNo("201578167291");
        form.setGender(0);
        form.setStudentName("hah");
        System.out.println(service.update(form));
    }

    @Test
    public void insertStudent() {
        StudentAddForm form = new StudentAddForm();
        StudentBuilder builder = new StudentBuilder();
        Student student = builder.generate();
        BeanUtils.copyProperties(student, form);
        System.out.println(service.addStudent(form));
    }

    @Test
    public void selectByStudentNo() {
        System.out.println(service.info("202040823585"));
    }
}
