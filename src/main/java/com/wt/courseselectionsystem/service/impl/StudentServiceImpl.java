package com.wt.courseselectionsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wt.courseselectionsystem.common.ResultUtils;
import com.wt.courseselectionsystem.common.SystemUtils;
import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.dao.StudentDao;
import com.wt.courseselectionsystem.model.dao.basebean.Student;
import com.wt.courseselectionsystem.model.vo.request.student.StudentAddForm;
import com.wt.courseselectionsystem.model.vo.request.student.StudentListQuery;
import com.wt.courseselectionsystem.model.vo.request.student.StudentUpdateForm;
import com.wt.courseselectionsystem.model.vo.response.student.StudentListVo;
import com.wt.courseselectionsystem.model.vo.response.student.StudentVo;
import com.wt.courseselectionsystem.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author lixin
 */
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public DataResult<StudentListVo> list(StudentListQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<Student> list = studentDao.selectStudentInfo(query);
        PageInfo<Student> info = new PageInfo<>(list);
        StudentListVo result = new StudentListVo();
        result.setList(SystemUtils.easyCopy(list, StudentVo.class));
        SystemUtils.configPageInfo(result, info);
        return ResultUtils.success(result);
    }

    @Override
    public NoDataResult update(StudentUpdateForm form) {
        Student student = new Student();
        BeanUtils.copyProperties(form, student);
        int row = studentDao.updateStudentInfo(student);
        if (row == 1) {
            return ResultUtils.success("????????????");
        } else {
            return ResultUtils.fail("????????????");
        }
    }

    @Override
    public NoDataResult addStudent(StudentAddForm form) {
        if (!Objects.isNull(studentDao.selectByStudentNo(form.getStudentNo()))) {
            return ResultUtils.fail("??????????????????");
        }
        Student student = new Student();
        BeanUtils.copyProperties(form, student);
        int row = studentDao.insertStudent(student);
        if (row == 1) {
            return ResultUtils.success("????????????");
        } else {
            return ResultUtils.fail("????????????");
        }
    }

    @Override
    public DataResult<StudentVo> info(String studentNo) {
        StudentVo studentVo = new StudentVo();
        Student student = Optional.ofNullable(studentDao.selectByStudentNo(studentNo)).orElse(new Student());
        BeanUtils.copyProperties(student, studentVo);
        return ResultUtils.success(studentVo);
    }

    @Override
    public NoDataResult delete(String studentNo) {
        int row = studentDao.delete(studentNo);
        if (row == 1) {
            return ResultUtils.success("????????????");
        } else {
            return ResultUtils.fail("????????????");
        }
    }
}
