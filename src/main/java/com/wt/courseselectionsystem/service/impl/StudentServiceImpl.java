package com.wt.courseselectionsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wt.courseselectionsystem.common.ResultUtils;
import com.wt.courseselectionsystem.common.SystemUtils;
import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.dao.StudentDao;
import com.wt.courseselectionsystem.model.dao.basebean.Student;
import com.wt.courseselectionsystem.model.vo.request.StudentQuery;
import com.wt.courseselectionsystem.model.vo.response.StudentVo;
import com.wt.courseselectionsystem.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public DataResult<List<StudentVo>> list(StudentQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<Student> list = studentDao.select(query);
        List<StudentVo> studentVos = SystemUtils.easyCopy(list, StudentVo.class);
        PageInfo<StudentVo> info = new PageInfo<>(studentVos);
        return ResultUtils.success(info.getList());
    }

    @Override
    public NoDataResult update(StudentVo studentVo) {
        Student student = new Student();
        BeanUtils.copyProperties(studentVo, student);
        int row = studentDao.updateStudentInfo(student);
        if (row == 1) {
            return ResultUtils.success("修改成功");
        } else {
            return ResultUtils.fail("修改失败");
        }

    }

    @Override
    public NoDataResult addStudent(StudentVo studentVo) {
        Student student = new Student();
        BeanUtils.copyProperties(studentVo, student);
        int row = studentDao.insertStudent(student);
        if (row == 1) {
            return ResultUtils.success("添加成功");
        } else {
            return ResultUtils.fail("添加失败");
        }
    }

    @Override
    public DataResult<StudentVo> info(String studentNo) {
        StudentVo studentVo = new StudentVo();
        Student student = studentDao.selectByStudentNo(studentNo);
        BeanUtils.copyProperties(student, studentVo);
        return ResultUtils.success(studentVo);
    }

    @Override
    public NoDataResult delete(String studentNo) {
        int row = studentDao.delete(studentNo);
        if (row == 1) {
            return ResultUtils.success("删除成功");
        } else {
            return ResultUtils.fail("删除失败");
        }
    }
}
