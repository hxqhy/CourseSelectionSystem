package com.wt.courseselectionsystem.controller;

import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanAddForm;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanInfoQuery;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanUpdateForm;
import com.wt.courseselectionsystem.model.vo.request.course.plan.StudentsOfCoursePlanForm;
import com.wt.courseselectionsystem.model.vo.response.StudentsOfCoursePlanVo;
import com.wt.courseselectionsystem.model.vo.response.course.plan.CoursePlanListVo;
import com.wt.courseselectionsystem.model.vo.response.course.plan.CoursePlanVo;
import com.wt.courseselectionsystem.service.CoursePlanService;
import org.springframework.web.bind.annotation.*;

/**
 * @author HY
 */
@RestController
@RequestMapping("/course/plan")
public class CoursePlanController {
    private final CoursePlanService coursePlanService;

    public CoursePlanController(CoursePlanService coursePlanService) {
        this.coursePlanService = coursePlanService;
    }

    @PostMapping("/add")
    public NoDataResult add(@RequestBody CoursePlanAddForm form) {
        return coursePlanService.addCoursePlan(form);
    }

    @PostMapping("/list")
    public DataResult<CoursePlanListVo> list(@RequestBody CoursePlanInfoQuery query) {
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

    @DeleteMapping()
    public NoDataResult delete(String teacherNo) {
        return coursePlanService.delete(teacherNo);
    }

    @PostMapping("/students")
    public DataResult<StudentsOfCoursePlanVo> students(@RequestBody StudentsOfCoursePlanForm form) {
        return coursePlanService.students(form);
    }

}
