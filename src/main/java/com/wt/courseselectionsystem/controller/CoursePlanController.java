package com.wt.courseselectionsystem.controller;

import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.model.vo.request.courseplan.CoursePlanAddForm;
import com.wt.courseselectionsystem.model.vo.request.courseplan.CoursePlanQuery;
import com.wt.courseselectionsystem.model.vo.request.courseplan.CoursePlanUpdateForm;
import com.wt.courseselectionsystem.model.vo.response.CoursePlanVo;
import com.wt.courseselectionsystem.service.CoursePlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author HY
 */
@RestController
@RequestMapping("/courseplan")
public class CoursePlanController {
    private final CoursePlanService coursePlanService;

    public CoursePlanController(CoursePlanService coursePlanService) {
        this.coursePlanService = coursePlanService;
    }

    @PostMapping("/add")
    public NoDataResult addCourse(@RequestBody CoursePlanAddForm form) {
        return coursePlanService.addCoursePlan(form);
    }

    @PostMapping("/list")
    public DataResult<List<CoursePlanVo>> list(@RequestBody CoursePlanQuery query) {
        return coursePlanService.list(query);
    }

    @PostMapping("/update")
    public NoDataResult update(@RequestBody CoursePlanUpdateForm form) {
        return coursePlanService.update(form);
    }

    @GetMapping("/info")
    public DataResult<CoursePlanVo> info(String coursePlanNo) {
        return coursePlanService.info(coursePlanNo);
    }

    public NoDataResult delete(String teacherNo) {
        return coursePlanService.delete(teacherNo);
    }

}
