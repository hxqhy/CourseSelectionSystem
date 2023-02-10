package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xxx
 */
@SpringBootTest
public class CourseDaoTest {
    @Autowired
    private CourseDao courseDao;

    @Test
    public void testInsert() {
        Course course = new Course();
        course.setCourseNo("123");
        course.setCourseHours(21);
        course.setCourseName("英语");
        course.setCredit(3);
        course.setStudentNumber(12);
        courseDao.insertCourse(course);
    }

    @Test
    public void testSelect() {
        System.out.println(courseDao.selectByCourseNo("123"));

    }
}

