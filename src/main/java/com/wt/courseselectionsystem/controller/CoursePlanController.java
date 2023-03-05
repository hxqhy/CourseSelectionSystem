package com.wt.courseselectionsystem.controller;

import com.wt.courseselectionsystem.common.annotation.LimitAbility;
import com.wt.courseselectionsystem.common.annotation.LoginRequired;
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

import static com.wt.courseselectionsystem.common.constant.AccountConstant.ADMIN_CODE;
import static com.wt.courseselectionsystem.common.constant.AccountConstant.TEACHER_CODE;

/**
 * @author HY
 */
@RestController
@RequestMapping("/course/plan")
@LoginRequired(role = {ADMIN_CODE})
public class CoursePlanController {

    private final CoursePlanService coursePlanService;

    public CoursePlanController(CoursePlanService coursePlanService) {
        this.coursePlanService = coursePlanService;
    }

    @PostMapping("/add")
    public NoDataResult add(@Validated @RequestBody CoursePlanAddForm form) {
        return coursePlanService.addCoursePlan(form);
    }

    @LoginRequired
    @PostMapping("/list")
    @LimitAbility(CoursePlanInfoListQueryLimiter.class)
    public DataResult<CoursePlanListVo> list(CoursePlanInfoQuery query) {
        return coursePlanService.list(query);
    }

    @PostMapping("/update")
    public NoDataResult update(@Validated @RequestBody CoursePlanUpdateForm form) {
        return coursePlanService.update(form);
    }

    @LoginRequired
    @GetMapping("/info")
    public DataResult<CoursePlanVo> info(String coursePlanNo) {
        return coursePlanService.info(coursePlanNo);
    }

    @DeleteMapping()
    public NoDataResult delete(String coursePlanNo) {
        return coursePlanService.delete(coursePlanNo);
    }

    /**
     * 获取课程的学生列表
     *
     * @param form ...
     * @return ...
     */
    @LoginRequired(role = {TEACHER_CODE, ADMIN_CODE})
    @PostMapping("/students")
    public DataResult<StudentsOfCoursePlanVo> students(@RequestBody StudentsOfCoursePlanQuery form) {
        return coursePlanService.students(form);
    }
}
