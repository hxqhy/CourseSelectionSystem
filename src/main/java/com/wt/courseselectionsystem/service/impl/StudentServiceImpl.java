package com.wt.courseselectionsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wt.courseselectionsystem.common.SystemUtils;
import com.wt.courseselectionsystem.dao.StudentDao;
import com.wt.courseselectionsystem.model.dao.basebean.Student;
import com.wt.courseselectionsystem.model.vo.request.StudentQuery;
import com.wt.courseselectionsystem.model.vo.result.StudentVo;
import com.wt.courseselectionsystem.service.StudentService;
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
    public List<StudentVo> query(StudentQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<Student> list = studentDao.select(query);
        List<StudentVo> studentVos = SystemUtils.easyCopy(list, StudentVo.class);
        PageInfo<StudentVo> info = new PageInfo<>(studentVos);
        return info.getList();
    }

}
