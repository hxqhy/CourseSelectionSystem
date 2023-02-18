package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.model.dao.basebean.Teacher;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherAddForm;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherListQuery;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherUpdateForm;
import com.wt.courseselectionsystem.utils.TeacherBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author HY
 */
@SpringBootTest
public class TeacherServiceTest {

    @Autowired
    private TeacherService service;

    @Test
    public void testTeacherQuery() {
        TeacherListQuery query = new TeacherListQuery();
        query.setTeacherName("张");
        System.out.println(service.list(query).getData());
    }

    @Test
    public void updateTeacher() {
        TeacherUpdateForm form = new TeacherUpdateForm();
        form.setTeacherNo("201665489569");
        form.setTeacherName("杰克");
        System.out.println(service.update(form));
    }

    @Test
    public void insertTeacher() {
        TeacherAddForm form = new TeacherAddForm();
        TeacherBuilder builder = new TeacherBuilder();
        Teacher teacher = builder.generate();
        BeanUtils.copyProperties(teacher, form);
        System.out.println(service.addTeacher(form));
    }

    @Test
    public void selectByTeacherNo() {
        System.out.println(service.info("201665489569"));
    }
}
