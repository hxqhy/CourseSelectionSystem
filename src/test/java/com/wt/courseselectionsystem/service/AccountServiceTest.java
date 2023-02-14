package com.wt.courseselectionsystem.service;

import com.wt.courseselectionsystem.dao.StudentDao;
import com.wt.courseselectionsystem.model.dao.basebean.Student;
import com.wt.courseselectionsystem.model.vo.request.account.ActiveStudentForm;
import com.wt.courseselectionsystem.model.vo.request.student.StudentQuery;
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

    @Test
    public void testActivateStudentAccount() {
        List<String> studentNos = studentDao.select(new StudentQuery())
                .stream().map(Student::getStudentNo).collect(Collectors.toList());
        ActiveStudentForm form = new ActiveStudentForm();
        form.setStudentNos(studentNos);
        System.out.println(accountService.activateStudentList(form));
    }
}
