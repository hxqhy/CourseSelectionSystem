package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.Course;
import com.wt.courseselectionsystem.model.vo.request.course.CourseQuery;
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
    public void testSelectByCourseNo() {
        System.out.println(courseDao.selectByCourseNo("123"));

    }

    @Test
    public void testSelect() {
        CourseQuery query = new CourseQuery();
        query.setCourseHours(30);
        System.out.println(courseDao.select(query));
    }

    @Test
    public void testUpdate() {
        Course course = new Course();
        course.setCourseNo("123");
        course.setCourseName("大学英语2");
        System.out.println(courseDao.updateCourseInfo(course));
    }

    @Test
    public void testDelete() {
        System.out.println(courseDao.delete("123"));
    }
}

