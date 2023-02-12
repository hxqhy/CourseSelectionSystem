package com.wt.courseselectionsystem.data;

import com.wt.courseselectionsystem.dao.StudentDao;
import com.wt.courseselectionsystem.dao.TeacherDao;
import com.wt.courseselectionsystem.utils.StudentBuilder;
import com.wt.courseselectionsystem.utils.TeacherBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author lixin
 */
@SpringBootTest
public class TestData {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private TeacherDao teacherDao;

    @Test
    public void students() {
        StudentBuilder builder = new StudentBuilder();
        addData(builder::generate, (data) -> studentDao.insertStudent(data), 100);
    }

    @Test
    public void teachers() {
        TeacherBuilder builder = new TeacherBuilder();
        addData(builder::generate, (data) -> teacherDao.insertTeacher(data), 200);
    }

    private <T> void addData(Supplier<T> supplier, Consumer<T> consumer, int num) {
        for (int i = 0; i < num; i++) {
            T data = supplier.get();
            try {
                consumer.accept(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
