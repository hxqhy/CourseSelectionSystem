package com.wt.courseselectionsystem.controller;

import com.wt.courseselectionsystem.common.annotation.LoginRequired;
import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.model.vo.request.course.CourseAddForm;
import com.wt.courseselectionsystem.model.vo.request.course.CourseListQuery;
import com.wt.courseselectionsystem.model.vo.request.course.CourseUpdateForm;
import com.wt.courseselectionsystem.model.vo.response.course.CourseListVo;
import com.wt.courseselectionsystem.model.vo.response.course.CourseSelectListVo;
import com.wt.courseselectionsystem.model.vo.response.course.CourseVo;
import com.wt.courseselectionsystem.service.CourseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.wt.courseselectionsystem.common.constant.AccountConstant.ADMIN_CODE;

/**
 * @author HY
 */
@RestController
@RequestMapping("/course")
@LoginRequired(role = {ADMIN_CODE})
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/add")
    public NoDataResult addCourse(@Validated @RequestBody CourseAddForm form) {
        return courseService.addCourse(form);
    }

    @PostMapping("/list")
    public DataResult<CourseListVo> list(@RequestBody CourseListQuery query) {
        return courseService.list(query);
    }

    @PostMapping("/update")
    public NoDataResult update(@Validated @RequestBody CourseUpdateForm form) {
        return courseService.update(form);
    }

    @GetMapping("/info")
    public DataResult<CourseVo> info(String courseNo) {
        return courseService.info(courseNo);
    }

    @DeleteMapping()
    public NoDataResult delete(String courseNo) {
        return courseService.delete(courseNo);
    }

    @LoginRequired
    @GetMapping("/selection_list")
    public DataResult<CourseSelectListVo> selectionList(String courseNo) {
        return courseService.selectionList(courseNo);
    }
}
