package com.wt.courseselectionsystem.data;

import com.wt.courseselectionsystem.common.constant.AccountConstant;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.dao.AccountDao;
import com.wt.courseselectionsystem.dao.CourseDao;
import com.wt.courseselectionsystem.dao.StudentDao;
import com.wt.courseselectionsystem.dao.TeacherDao;
import com.wt.courseselectionsystem.model.dao.basebean.Account;
import com.wt.courseselectionsystem.model.dao.basebean.Course;
import com.wt.courseselectionsystem.model.dao.basebean.Teacher;
import com.wt.courseselectionsystem.model.vo.request.course.CourseListQuery;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanAddForm;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherListQuery;
import com.wt.courseselectionsystem.service.CoursePlanService;
import com.wt.courseselectionsystem.utils.CourseBuilder;
import com.wt.courseselectionsystem.utils.RandomDataUtils;
import com.wt.courseselectionsystem.utils.StudentBuilder;
import com.wt.courseselectionsystem.utils.TeacherBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.wt.courseselectionsystem.common.SystemUtils.passwordEncode;

/**
 * @author lixin
 */
@SpringBootTest
public class TestData {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private CoursePlanService coursePlanService;

    @Test
    public void account() {
        Account account = new Account();
        account.setAccountNo("admin");
        account.setPassword(passwordEncode("admin"));
        account.setAccountType(AccountConstant.ADMIN_CODE);
        System.out.println(accountDao.insertAccount(account) == 1);
    }

    @Test
    public void students() {
        StudentBuilder builder = new StudentBuilder();
        addData(builder::generate, (data) -> studentDao.insertStudent(data), 200);
    }

    @Test
    public void teachers() {
        TeacherBuilder builder = new TeacherBuilder();
        addData(builder::generate, (data) -> teacherDao.insertTeacher(data), 200);
    }

    @Test
    public void courses() {
        CourseBuilder builder = new CourseBuilder();
        String courseNames = "生命伦理学/昆虫与文化/国学概论/中医药与文化传统/科技英语/圣经文学选读/旅游英语/东欧文化" +
                "/法国文化/德国文化/西方文化概论/外刊选读/英美文学鉴赏/日本文化史/多媒体视听说/中国通史/心理学/中国传统文化与现代人生" +
                "/佛教与中国文化/世界文化史/管理心理学/伦理学/科学思想史/全球化与公共健康/法律与生活/园艺与健康/农业经济学/公司理财" +
                "/太极拳/法律逻辑学/中国文化与实用谈判/环境化学与人类健康/艺术导论/音乐鉴赏/书法鉴赏/金庸小说赏析/社交礼仪/营养学";
        List<String> list = Arrays.asList(courseNames.split("/"));
        List<Course> courses = list.stream().map(builder::generate).collect(Collectors.toList());
        addData(courses, (data) -> courseDao.insertCourse(data));
        System.out.println(list);
    }

    @Test
    public void coursePlans() {
        List<String> teacherNo = teacherDao.selectTeacherInfo(new TeacherListQuery()).stream()
                .map(Teacher::getTeacherNo)
                .limit(20)
                .collect(Collectors.toList());
        List<String> courseNo = courseDao.selectCourseInfo(new CourseListQuery()).stream()
                .map(Course::getCourseNo)
                .limit(20)
                .collect(Collectors.toList());
        for (int i = 0; i < 50; ) {
            CoursePlanAddForm form = new CoursePlanAddForm();
            form.setTeacherNo(RandomDataUtils.choice(teacherNo));
            form.setCourseNo(RandomDataUtils.choice(courseNo));
            try {
                NoDataResult result = coursePlanService.addCoursePlan(form);
                if (result.getCode() == 200) {
                    i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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

    private <T> void addData(List<T> list, Consumer<T> consumer) {
        for (T data : list) {
            try {
                consumer.accept(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
