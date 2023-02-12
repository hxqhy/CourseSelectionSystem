package com.wt.courseselectionsystem.utils;

import com.wt.courseselectionsystem.model.dao.basebean.Teacher;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author lixin
 */
public class TeacherBuilder {

    public Teacher generate() {
        Teacher teacher = new Teacher();
        teacher.setTeacherNo(generateTeacherNo());
        int gender = RandomDataUtils.generateGender();
        String name = RandomDataUtils.generateName(gender);
        teacher.setGender(gender);
        teacher.setTeacherName(name);
        return teacher;
    }

    private String generateTeacherNo() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int year = random.nextInt(2002, 2020);
        StringBuilder builder = new StringBuilder(Integer.toString(year));
        for (int i = 0; i < 8; i++) {
            builder.append(random.nextInt(10));
        }
        return builder.toString();
    }
}
