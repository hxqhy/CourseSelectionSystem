package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.model.dao.basebean.Course;
import com.wt.courseselectionsystem.model.vo.request.course.CourseAddForm;
import com.wt.courseselectionsystem.model.vo.request.course.CourseQuery;
import com.wt.courseselectionsystem.model.vo.request.course.CourseUpdateForm;
import com.wt.courseselectionsystem.utils.CourseBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author HY
 */
@SpringBootTest
public class CourseServiceTest {
    @Autowired
    private CourseService service;

    @Test
    public void testCourseQuery() {
        CourseQuery query = new CourseQuery();
        System.out.println(service.list(query).getData().size());
    }

    @Test
    public void updateCourseInfo() {
        CourseUpdateForm form = new CourseUpdateForm();
        form.setCourseNo("1234");
        form.setCourseName("生命伦理学");
        form.setCredit(10);

        System.out.println(service.update(form));
    }

    @Test
    public void insertCourse() {
        CourseAddForm form = new CourseAddForm();
        CourseBuilder builder = new CourseBuilder();
        Course course = builder.generate("web");
        BeanUtils.copyProperties(course, form);
        System.out.println(service.addCourse(form));
    }

    @Test
    public void selectByCourseNo() {
        System.out.println(service.info("1234"));
    }

}
