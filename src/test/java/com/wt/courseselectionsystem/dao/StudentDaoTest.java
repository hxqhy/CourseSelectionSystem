package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.Student;
import com.wt.courseselectionsystem.model.vo.request.student.StudentQuery;
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
        Student student = builder.generate();
        System.out.println(studentDao.insertStudent(student) == 1);
    }

    @Test
    public void testSelectStudentByStudentNo() {
        System.out.println(studentDao.selectByStudentNo("201578167291"));
    }

    @Test
    public void testSelect() {
        StudentQuery query = new StudentQuery();
        query.setGender(1);
        query.setActive(1);
        System.out.println(studentDao.select(query));
    }

    @Test
    public void testUpdate() {
        Student student = new Student();//202040823585
        student.setStudentNo("201578167291");
        student.setGender(0);
        student.setStudentName("xiaoxiao");
        System.out.println(studentDao.updateStudentInfo(student));
    }

    @Test
    public void testDelete() {
        System.out.println(studentDao.delete("202040823585"));
    }

}
