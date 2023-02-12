package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.model.vo.request.courseplan.CoursePlanAddForm;
import com.wt.courseselectionsystem.model.vo.request.courseplan.CoursePlanQuery;
import com.wt.courseselectionsystem.model.vo.request.courseplan.CoursePlanUpdateForm;
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
        CoursePlanQuery query = new CoursePlanQuery();
        System.out.println(service.list(query).getData().size());
    }

    @Test
    public void updateCoursePlanInfo() {
        CoursePlanUpdateForm form = new CoursePlanUpdateForm();
        form.setCoursePlanNo("123");
        form.setCourseNo("123445");
        System.out.println(service.update(form));
    }

    @Test
    public void insertCoursePlan() {
        CoursePlanAddForm form = new CoursePlanAddForm();
        form.setCourseNo("123");
        form.setCoursePlanNo("1234");
        form.setTeacherNo("12345");
        System.out.println(service.addCoursePlan(form));
    }

    @Test
    public void selectByCoursePlanNo() {
        System.out.println(service.info("123"));
    }

}
