package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.CoursePlan;
import com.wt.courseselectionsystem.model.dao.basebean.CourseSelection;
import com.wt.courseselectionsystem.model.dao.basebean.Student;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanQuery;
import com.wt.courseselectionsystem.model.vo.request.student.StudentQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xxx
 */
@SpringBootTest
public class CourseSelectionDaoTest {

    @Autowired
    private CourseSelectionDao courseSelectionDao;

    @Test
    public void testInsert() {
        CourseSelection courseSelection = new CourseSelection();
        courseSelection.setCoursePlanNo("123");
        courseSelection.setStudentNo("123");
        courseSelectionDao.insertCourseSelection(courseSelection);
    }
}
