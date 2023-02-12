package com.wt.courseselectionsystem.controller;

import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherAddForm;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherQuery;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherUpdateForm;
import com.wt.courseselectionsystem.model.vo.response.TeacherVo;
import com.wt.courseselectionsystem.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author HY
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/add")
    public NoDataResult addTeacher(@RequestBody TeacherAddForm form) {
        return teacherService.addTeacher(form);
    }

    @PostMapping("/list")
    public DataResult<List<TeacherVo>> list(@RequestBody TeacherQuery query) {
        return teacherService.list(query);
    }

    @PostMapping("/update")
    public NoDataResult update(@RequestBody TeacherUpdateForm form) {
        return teacherService.update(form);
    }

    @GetMapping("/info")
    public DataResult<TeacherVo> info(String teacherNo) {
        return teacherService.info(teacherNo);
    }

    public NoDataResult delete(String teacherNo) {
        return teacherService.delete(teacherNo);
    }

}
