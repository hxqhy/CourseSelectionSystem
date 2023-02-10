package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.CoursePlan;
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
    public void testSelect(){
        System.out.println(coursePlanDao.selectByCoursePlan("123"));
    }
}
