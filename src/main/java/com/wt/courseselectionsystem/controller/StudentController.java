package com.wt.courseselectionsystem.controller;

import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.model.vo.request.StudentQuery;
import com.wt.courseselectionsystem.model.vo.result.StudentVo;
import com.wt.courseselectionsystem.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return studentService.query(query);
    }
}
