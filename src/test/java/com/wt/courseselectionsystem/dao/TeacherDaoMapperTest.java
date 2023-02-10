package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xxx
 */
@SpringBootTest
public class TeacherDaoMapperTest {
    @Autowired
    private TeacherDao teacherDao;

    @Test
    public void testInsert() {
        Teacher teacher = new Teacher();
        teacher.setTeacherNo("123");
        teacher.setTeacherName("小王");
        teacher.setGender(1);
        teacherDao.insertTeacher(teacher);
    }

    @Test
    public void testSelect() {
        System.out.println(teacherDao.selectByTeacherNo("123"));
    }
}
