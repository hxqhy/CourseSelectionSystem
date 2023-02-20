package com.wt.courseselectionsystem.controller;

import com.wt.courseselectionsystem.common.annotation.LimitAbility;
import com.wt.courseselectionsystem.common.annotation.limiter.CoursePlanInfoListQueryLimiter;
import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanAddForm;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanInfoQuery;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanUpdateForm;
import com.wt.courseselectionsystem.model.vo.request.course.plan.StudentsOfCoursePlanQuery;
import com.wt.courseselectionsystem.model.vo.response.course.plan.CoursePlanListVo;
import com.wt.courseselectionsystem.model.vo.response.course.plan.CoursePlanVo;
import com.wt.courseselectionsystem.model.vo.response.course.plan.StudentsOfCoursePlanVo;
import com.wt.courseselectionsystem.service.CoursePlanService;
import org.springframework.validation.annotation.Validated;
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
    public NoDataResult add(@Validated @RequestBody CoursePlanAddForm form) {
        return coursePlanService.addCoursePlan(form);
    }

    @PostMapping("/list")
    @LimitAbility(CoursePlanInfoListQueryLimiter.class)
    public DataResult<CoursePlanListVo> list(CoursePlanInfoQuery query) {
        return coursePlanService.list(query);
    }

    @PostMapping("/update")
    public NoDataResult update(@Validated @RequestBody CoursePlanUpdateForm form) {
        return coursePlanService.update(form);
    }

    @GetMapping("/info")
    public DataResult<CoursePlanVo> info(String coursePlanNo) {
        return coursePlanService.info(coursePlanNo);
    }

    @DeleteMapping()
    public NoDataResult delete(String coursePlanNo) {
        return coursePlanService.delete(coursePlanNo);
    }

    @PostMapping("/students")
    public DataResult<StudentsOfCoursePlanVo> students(@RequestBody StudentsOfCoursePlanQuery form) {
        return coursePlanService.students(form);
    }
}
