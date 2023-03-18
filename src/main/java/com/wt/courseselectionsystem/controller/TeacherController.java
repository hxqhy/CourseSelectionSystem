package com.wt.courseselectionsystem.controller;

import com.wt.courseselectionsystem.common.annotation.LimitAbility;
import com.wt.courseselectionsystem.common.annotation.LoginRequired;
import com.wt.courseselectionsystem.common.annotation.limiter.TeacherInfoQueryLimiter;
import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherAddForm;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherListQuery;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherUpdateForm;
import com.wt.courseselectionsystem.model.vo.response.teacher.TeacherListVo;
import com.wt.courseselectionsystem.model.vo.response.teacher.TeacherSelectListVo;
import com.wt.courseselectionsystem.model.vo.response.teacher.TeacherVo;
import com.wt.courseselectionsystem.service.TeacherService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.wt.courseselectionsystem.common.constant.AccountConstant.ADMIN_CODE;

/**
 * @author HY
 */
@RestController
@RequestMapping("/teacher")
@LoginRequired(role = {ADMIN_CODE})
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/add")
    public NoDataResult addTeacher(@Validated @RequestBody TeacherAddForm form) {
        return teacherService.addTeacher(form);
    }

    @PostMapping("/list")
    public DataResult<TeacherListVo> list(@RequestBody TeacherListQuery query) {
        return teacherService.list(query);
    }

    @PostMapping("/update")
    public NoDataResult update(@Validated @RequestBody TeacherUpdateForm form) {
        return teacherService.update(form);
    }

    @LoginRequired
    @GetMapping("/info")
    @LimitAbility(TeacherInfoQueryLimiter.class)
    public DataResult<TeacherVo> info(String teacherNo) {
        return teacherService.info(teacherNo);
    }

    @DeleteMapping()
    public NoDataResult delete(String teacherNo) {
        return teacherService.delete(teacherNo);
    }

    /**
     * assisted selection list
     * <p>
     * 辅助选择列表
     * </p>
     *
     * @param teacherNo teacher no
     * @return list
     */
    @LoginRequired
    @GetMapping("/selection_list")
    public DataResult<TeacherSelectListVo> selectionList(String teacherNo) {
        return teacherService.selectionList(teacherNo);
    }

}
