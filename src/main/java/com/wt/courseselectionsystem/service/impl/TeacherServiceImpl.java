package com.wt.courseselectionsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wt.courseselectionsystem.common.ResultUtils;
import com.wt.courseselectionsystem.common.SystemUtils;
import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.dao.TeacherDao;
import com.wt.courseselectionsystem.model.dao.basebean.Teacher;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherAddForm;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherListQuery;
import com.wt.courseselectionsystem.model.vo.request.teacher.TeacherUpdateForm;
import com.wt.courseselectionsystem.model.vo.response.teacher.TeacherListVo;
import com.wt.courseselectionsystem.model.vo.response.teacher.TeacherVo;
import com.wt.courseselectionsystem.service.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author HY
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherDao teacherDao;

    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public NoDataResult addTeacher(TeacherAddForm form) {
        if (!Objects.isNull(teacherDao.selectByTeacherNo(form.getTeacherNo()))) {
            return ResultUtils.fail("教师编号重复");
        }
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(form, teacher);
        int rows = teacherDao.insertTeacher(teacher);
        if (rows == 1) {
            return ResultUtils.success("添加成功");
        } else {
            return ResultUtils.fail("添加失败");
        }
    }

    @Override
    public DataResult<TeacherListVo> list(TeacherListQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<Teacher> list = teacherDao.selectTeacherInfo(query);
        PageInfo<Teacher> info = new PageInfo<>(list);
        TeacherListVo result = new TeacherListVo();
        result.setList(SystemUtils.easyCopy(list, TeacherVo.class));
        SystemUtils.configPageInfo(result, info);
        return ResultUtils.success(result);
    }

    @Override
    public NoDataResult update(TeacherUpdateForm form) {
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(form, teacher);
        int rows = teacherDao.updateTeacherInfo(teacher);
        if (rows == 1) {
            return ResultUtils.success("修改成功");
        } else {
            return ResultUtils.fail("修改失败");
        }
    }

    @Override
    public DataResult<TeacherVo> info(String teacherNo) {
        TeacherVo teacherVo = new TeacherVo();
        Teacher teacher = Optional.ofNullable(teacherDao.selectByTeacherNo(teacherNo)).orElse(new Teacher());
        BeanUtils.copyProperties(teacher, teacherVo);
        return ResultUtils.success(teacherVo);
    }

    @Override
    public NoDataResult delete(String teacherNo) {
        int row = teacherDao.delete(teacherNo);
        if (row == 1) {
            return ResultUtils.success("删除成功");
        } else {
            return ResultUtils.fail("删除失败");
        }
    }
}
