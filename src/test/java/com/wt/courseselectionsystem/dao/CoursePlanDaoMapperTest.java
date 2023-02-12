package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.CoursePlan;
import com.wt.courseselectionsystem.model.vo.request.courseplan.CoursePlanQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xxx
 */
@SpringBootTest
public class CoursePlanDaoMapperTest {
    @Autowired
    private CoursePlanDao coursePlanDao;

    @Test
    public void testInsert() {
        CoursePlan coursePlan = new CoursePlan();
        coursePlan.setCoursePlanNo("123");
        coursePlan.setCourseNo("123");
        coursePlan.setTeacherNo("123");
        coursePlanDao.insertCoursePlan(coursePlan);
    }

    @Test
    public void testSelectByCoursePlanNo() {
        System.out.println(coursePlanDao.selectByCoursePlan("123"));
    }

    @Test
    public void testSelect() {
        CoursePlanQuery course = new CoursePlanQuery();
        course.setCourseNo("123");
        System.out.println(coursePlanDao.select(course));
    }

    @Test
    public void testUpdate() {
        CoursePlan coursePlan = new CoursePlan();
        coursePlan.setCoursePlanNo("123");
        coursePlan.setCoursePlanNo("123456");
        System.out.println(coursePlanDao.updateInfo(coursePlan));
    }

    @Test
    public void testDelete() {
        System.out.println(coursePlanDao.delete("123"));
    }
}
