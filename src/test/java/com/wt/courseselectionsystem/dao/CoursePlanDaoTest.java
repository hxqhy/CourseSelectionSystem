package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.CoursePlan;
import com.wt.courseselectionsystem.model.dao.exbean.CoursePlanInfo;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanAddForm;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanInfoQuery;
import com.wt.courseselectionsystem.model.vo.request.course.plan.StudentsOfCoursePlanForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

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
        CoursePlanAddForm form = new CoursePlanAddForm();
        coursePlan.setCourseNo("123112");
        coursePlan.setTeacherNo("12345");
        form.setCourseNo(coursePlan.getCourseNo());
        form.setTeacherNo(coursePlan.getTeacherNo());
        String s = generateCoursePlanNo(form, LocalDate.now());
        coursePlan.setCoursePlanNo(s);
        coursePlan.setCoursePlanYear(LocalDate.now().getYear() + "");
        coursePlanDao.insertCoursePlan(coursePlan);
    }

    @Test
    public void testSelectByCoursePlanNo() {
        System.out.println(coursePlanDao.selectInfoByCoursePlanNo("2005912933802419192023"));
    }

    @Test
    public void testSelect() {
        CoursePlanInfoQuery info = new CoursePlanInfoQuery();
        info.setTeacherName("小");
        List<CoursePlanInfo> infos = coursePlanDao.selectCoursePlanInfo(info);
        infos.forEach(System.out::println);
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

    private String generateCoursePlanNo(CoursePlanAddForm form, LocalDate date) {
        return form.getTeacherNo() + form.getCourseNo() + date.getYear();
    }
}
