package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.CoursePlan;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xxx
 */
@SpringBootTest
public class CoursePlanDaoTest {
    @Autowired
    private CoursePlanDao coursePlanDao;

    @Test
    public void testInsert() {
        CoursePlan coursePlan = new CoursePlan();
        coursePlan.setCoursePlanNo("23");
        coursePlan.setCourseNo("123");
        coursePlan.setTeacherNo("123");
        coursePlan.setCoursePlanYear("2014");
        coursePlanDao.insertCoursePlan(coursePlan);
    }

    @Test
    public void testSelectByCoursePlanNo() {
        System.out.println(coursePlanDao.selectByCoursePlanNo("23"));
    }

    @Test
    public void testSelect() {
        CoursePlanQuery query = new CoursePlanQuery();
        query.setCourseNo("123456");
        System.out.println(coursePlanDao.select(query));
    }

    @Test
    public void testUpdate() {
        CoursePlan coursePlan = new CoursePlan();
        coursePlan.setCoursePlanNo("123");
        coursePlan.setCourseNo("123456");
        coursePlan.setTeacherNo("111");
        System.out.println(coursePlanDao.updateInfo(coursePlan));
    }

    @Test
    public void testDelete() {
        System.out.println(coursePlanDao.delete("123"));
    }
}
