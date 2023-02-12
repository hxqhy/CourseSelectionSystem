package com.wt.courseselectionsystem.utils;

import com.wt.courseselectionsystem.model.dao.basebean.Student;

import java.util.concurrent.ThreadLocalRandom;

import static com.wt.courseselectionsystem.utils.RandomDataUtils.*;

/**
 * @author lixin
 */
public class StudentBuilder {

    public Student generate() {
        Student student = new Student();
        String studentNo = generateStudentNo();
        //学号
        student.setStudentNo(studentNo);
        int gender = generateGender();
        //性别
        student.setGender(gender);
        //姓名
        student.setStudentName(generateName(gender));
        //班级
        String year = studentNo.substring(0, 4);
        student.setStudentClass(generateStudentClass(year));
        return student;
    }

    /**
     * 生成学号
     *
     * @return ...
     */
    private String generateStudentNo() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int year = random.nextInt(2012, 2023);
        StringBuilder builder = new StringBuilder(Integer.toString(year));
        for (int i = 0; i < 8; i++) {
            builder.append(random.nextInt(10));
        }
        return builder.toString();
    }

    private final String[] major = {
            "软件工程", "网络工程", "市场营销", "生物工程", "行政管理", "工程造价", "应用化学", "财务管理",
            "市场营销", "应用数学", "学前教育", "人力资源管理", "审计学", "通信工程", "电子商务", "制药工程",
            "环境工程", "生物科学", "地理科学",
    };

    private String generateStudentClass(String year) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return year + choice(major) + random.nextInt(2) + random.nextInt(10) + "班";
    }


}
