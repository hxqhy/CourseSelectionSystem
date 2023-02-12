package com.wt.courseselectionsystem.controller;

import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.model.vo.request.student.StudentAddForm;
import com.wt.courseselectionsystem.model.vo.request.student.StudentQuery;
import com.wt.courseselectionsystem.model.vo.request.student.StudentUpdateForm;
import com.wt.courseselectionsystem.model.vo.response.StudentVo;
import com.wt.courseselectionsystem.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lixin
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/list")
    public DataResult<List<StudentVo>> list(@RequestBody StudentQuery query) {
        return studentService.list(query);
    }

    @PostMapping("/update")
    public NoDataResult update(@RequestBody StudentUpdateForm form) {
        return studentService.update(form);
    }

    @PostMapping("/add")
    public NoDataResult addStudent(@RequestBody StudentAddForm form) {
        return studentService.addStudent(form);
    }

    @GetMapping("/info")
    public DataResult<StudentVo> info(String studentNo) {
        return studentService.info(studentNo);
    }

    @DeleteMapping()
    public NoDataResult delete(String studentNo) {
        return studentService.delete(studentNo);
    }
}
