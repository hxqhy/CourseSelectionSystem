package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.model.dao.basebean.Student;
import com.wt.courseselectionsystem.model.vo.request.StudentQuery;
import com.wt.courseselectionsystem.model.vo.result.StudentVo;
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
    public void updateStudentInfo(){
        StudentVo studentVo = new StudentVo();
        studentVo.setStudentNo("202040823585");
        studentVo.setGender(0);
        studentVo.setStudentName("hahah");
        System.out.println(service.update(studentVo));
    }

    @Test
    public void insertStudent(){
        StudentVo studentVo = new StudentVo();
        StudentBuilder builder = new StudentBuilder();
        Student student = builder.generateStudent();
        BeanUtils.copyProperties(student,studentVo);
        System.out.println(service.addStudent(studentVo) );
    }
    @Test
    public void selectByStudentNo(){
        System.out.println(service.info("202040823585"));
    }
}
