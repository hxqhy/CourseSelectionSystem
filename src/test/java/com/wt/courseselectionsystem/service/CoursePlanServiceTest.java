package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanAddForm;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanInfoQuery;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanUpdateForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author HY
 */
@SpringBootTest
public class CoursePlanServiceTest {
    @Autowired
    private CoursePlanService service;

    @Test
    public void testCoursePlanQuery() {
        CoursePlanInfoQuery query = new CoursePlanInfoQuery();

        System.out.println(service.list(query).getData());
    }

    @Test
    public void updateCoursePlanInfo() {
        CoursePlanUpdateForm form = new CoursePlanUpdateForm();
        form.setCourseNo("2005912933802419192023");
        System.out.println(service.update(form));
    }

    @Test
    public void insertCoursePlan() {
        CoursePlanAddForm form = new CoursePlanAddForm();
        form.setCourseNo("123");
        form.setTeacherNo("12345");
        System.out.println(service.addCoursePlan(form));
    }

    @Test
    public void selectByCoursePlanNo() {
        System.out.println(service.info("2004876516665403932023"));
    }

}
