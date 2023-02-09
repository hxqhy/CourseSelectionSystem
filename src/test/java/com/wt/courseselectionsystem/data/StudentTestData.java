package com.wt.courseselectionsystem.data;

import com.wt.courseselectionsystem.model.dao.basebean.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author lixin
 */
@SpringBootTest
public class StudentTestData {

    @Test
    public void students() {
        Student student = generateStudent();
        System.out.println(student);
    }

    public Student generateStudent() {
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


    /**
     * 姓氏
     */
    private final String[] surname = {
            "张", "杨", "王", "刘", "马", "朱", "赵", "钱", "孙", "黎", "李",
            "何", "郑", "高", "吴", "宋", "沙", "丁", "周", "朱", "黄",
    };

    private final String[] boyName = {
            "建军", "清云", "永辉", "广志", "贵", "海", "云", "胜利", "强",
            "晓明", "宝华", "春秋", "中书", "京", "万", "星", "小东", "有义",
            "大壮", "东", "小龙", "小虎", "盛", "亮", "勇", "咏", "秋生", "磊",
            "华强", "杰"
    };

    private final String[] girlName = {
            "小英", "小美", "敏", "小妹", "梅梅", "慧", "丽", "秀", "娜娜", "秋水",
            "秋菊", "菲菲", "晶晶", "小满", "玛丽", "妙妙", "若英", "翠翠", "娜", "紫",
            "瑶", "秀娟", "玉萍", "小凤", "洁", "芸", "月", "悦", "巧", "乔乔"
    };

    /**
     * 生成姓名
     *
     * @return ...
     */
    private String generateName(int gender) {
        return choice(surname) + (gender == 1 ? choice(boyName) : choice(girlName));
    }

    private int generateGender() {
        return ThreadLocalRandom.current().nextInt(2);
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

    private String choice(String[] strings) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return strings[random.nextInt(strings.length)];
    }
}
