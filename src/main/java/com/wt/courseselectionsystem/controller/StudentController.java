package com.wt.courseselectionsystem.controller;

import com.wt.courseselectionsystem.common.annotation.LimitAbility;
import com.wt.courseselectionsystem.common.annotation.LoginRequired;
import com.wt.courseselectionsystem.common.annotation.limiter.StudentInfoQueryLimiter;
import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.model.vo.request.student.StudentAddForm;
import com.wt.courseselectionsystem.model.vo.request.student.StudentListQuery;
import com.wt.courseselectionsystem.model.vo.request.student.StudentUpdateForm;
import com.wt.courseselectionsystem.model.vo.response.student.StudentListVo;
import com.wt.courseselectionsystem.model.vo.response.student.StudentSelectListVo;
import com.wt.courseselectionsystem.model.vo.response.student.StudentVo;
import com.wt.courseselectionsystem.service.StudentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.wt.courseselectionsystem.common.constant.AccountConstant.ADMIN_CODE;

/**
 * @author lixin
 */
@RestController
@RequestMapping("/student")
@LoginRequired(role = {ADMIN_CODE})
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/list")
    public DataResult<StudentListVo> list(@RequestBody StudentListQuery query) {
        return studentService.list(query);
    }

    @PostMapping("/update")
    public NoDataResult update(@Validated @RequestBody StudentUpdateForm form) {
        return studentService.update(form);
    }

    @PostMapping("/add")
    public NoDataResult addStudent(@Validated @RequestBody StudentAddForm form) {
        return studentService.addStudent(form);
    }

    @LoginRequired
    @GetMapping("/info")
    @LimitAbility(StudentInfoQueryLimiter.class)
    public DataResult<StudentVo> info(String studentNo) {
        return studentService.info(studentNo);
    }

    @DeleteMapping()
    public NoDataResult delete(String studentNo) {
        return studentService.delete(studentNo);
    }

    @LoginRequired
    @GetMapping("/selection_list")
    public DataResult<StudentSelectListVo> selectionList(String studentNo) {
        return studentService.selectionList(studentNo);
    }

}
