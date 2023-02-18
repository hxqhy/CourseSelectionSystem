package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.CourseSelection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
