package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.Teacher;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherListQuery;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherQuery;
import com.wt.courseselectionsystem.model.vo.response.TeacherDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author xxx
 */
@SpringBootTest
public class TeacherDaoTest {

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
    public void testSelectByTeacherNo() {
        System.out.println(teacherDao.selectByTeacherNo("123"));
    }

    @Test
    public void testSelect() {
        TeacherQuery query = new TeacherQuery();
        query.setActive(1);
        System.out.println(teacherDao.select(query));
    }

    @Test
    public void testUpdate() {
        Teacher teacher = new Teacher();
        teacher.setTeacherNo("123");
        teacher.setTeacherName("cv");
        teacher.setGender(1);
        System.out.println(teacherDao.updateTeacherInfo(teacher));
    }

    @Test
    public void testDelete() {
        System.out.println(teacherDao.delete("123"));
    }

    @Test
    public void testDetails(){
        TeacherListQuery form = new TeacherListQuery();
        form.setTeacherNo("201880264102");
        form.setTeacherName("宋小美");
        List<TeacherDetails> teacherDetails = teacherDao.selectDetails(form);
        teacherDetails.forEach(System.out::println);
    }
}
