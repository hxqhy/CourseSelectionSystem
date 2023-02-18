package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.dao.StudentDao;
import com.wt.courseselectionsystem.dao.TeacherDao;
import com.wt.courseselectionsystem.model.dao.basebean.Student;
import com.wt.courseselectionsystem.model.dao.basebean.Teacher;
import com.wt.courseselectionsystem.model.vo.request.account.ActivateTeacherForm;
import com.wt.courseselectionsystem.model.vo.request.account.ActiveStudentForm;
import com.wt.courseselectionsystem.model.vo.request.account.ResetPasswordForm;
import com.wt.courseselectionsystem.model.vo.request.student.StudentListQuery;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherListQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lixin
 */
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private TeacherDao teacherDao;

    @Test
    public void testActivateStudentAccounts() {
        List<String> studentNos = studentDao.selectStudentInfo(new StudentListQuery())
                .stream().map(Student::getStudentNo).collect(Collectors.toList());
        ActiveStudentForm form = new ActiveStudentForm();
        form.setStudentNos(studentNos);
        System.out.println(accountService.activateStudentList(form));
    }

    @Test
    public void testActivateTeacherList() {
        List<String> teacherNos = teacherDao.selectTeacherInfo(new TeacherListQuery())
                .stream().map(Teacher::getTeacherNo).collect(Collectors.toList());
        ActivateTeacherForm form = new ActivateTeacherForm();
        form.setTeacherNo(teacherNos);
        System.out.println(accountService.activateTeacherList(form));
    }

    @Test
    public void testResetPassword() {
        ResetPasswordForm resetForm = new ResetPasswordForm();
        resetForm.setAccountNo("T200499750879");
        System.out.println(accountService.resetPassword(resetForm));
    }
}
