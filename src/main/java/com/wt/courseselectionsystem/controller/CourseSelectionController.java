package com.wt.courseselectionsystem.controller;

import com.wt.courseselectionsystem.common.SystemUtils;
import com.wt.courseselectionsystem.common.annotation.LoginRequired;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.model.dao.basebean.Account;
import com.wt.courseselectionsystem.model.vo.request.course.select.CourseSelectionSituationQuery;
import com.wt.courseselectionsystem.model.vo.request.course.select.SelectCourseForm;
import com.wt.courseselectionsystem.model.vo.response.course.select.CourseSelectionSituationListVo;
import com.wt.courseselectionsystem.service.CourseSelectionService;
import com.wt.courseselectionsystem.service.TokenService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.wt.courseselectionsystem.common.constant.AccountConstant.STUDENT_CODE;

/**
 * @author lixin
 */
@RestController
@RequestMapping("/select")
public class CourseSelectionController {

    private final CourseSelectionService courseSelectionService;

    private final TokenService<Account> tokenService;

    public CourseSelectionController(CourseSelectionService courseSelectionService,
                                     TokenService<Account> tokenService) {
        this.courseSelectionService = courseSelectionService;
        this.tokenService = tokenService;
    }

    @LoginRequired(role = {STUDENT_CODE})
    @PostMapping
    public NoDataResult select(@RequestBody SelectCourseForm form, @RequestHeader("token") String token) {
        String studentNo = Optional.of(tokenService.getData(token))
                .map(Account::getAccountNo)
                .map(SystemUtils::parseAccountNo)
                .orElseThrow(() -> new RuntimeException("获取学号失败"));
        return courseSelectionService.selectCourse(studentNo, form.getCoursePlanNo());
    }

    @PostMapping("/situation")
    public CourseSelectionSituationListVo infoList(@RequestBody CourseSelectionSituationQuery query) {
        return courseSelectionService.infoList(query);
    }

}
