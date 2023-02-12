package com.wt.courseselectionsystem.utils;

import com.wt.courseselectionsystem.model.dao.basebean.Course;

import java.util.concurrent.ThreadLocalRandom;

import static com.wt.courseselectionsystem.utils.RandomDataUtils.randomDigit;

/**
 * @author lixin
 */
public class CourseBuilder {

    public Course generate(String courseName) {
        Course course = new Course();
        course.setCourseNo(generateCourseNo());
        course.setCourseName(courseName);
        course.setCourseHours(generateCourseHours());
        course.setCredit(generateCredit());
        course.setStudentNumber(generateStudentNumber());
        return course;
    }

    private String generateCourseNo() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            builder.append(randomDigit());
        }
        return builder.toString();
    }

    private Integer generateCredit() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextInt(1, 5);
    }

    private Integer generateCourseHours() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextInt(1, 5) * 10;
    }

    private Integer generateStudentNumber() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextInt(1, 5) * 20;
    }
}
