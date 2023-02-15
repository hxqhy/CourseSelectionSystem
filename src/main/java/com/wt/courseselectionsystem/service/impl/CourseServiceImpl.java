package com.wt.courseselectionsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wt.courseselectionsystem.common.ResultUtils;
import com.wt.courseselectionsystem.common.SystemUtils;
import com.wt.courseselectionsystem.common.result.DataResult;
import com.wt.courseselectionsystem.common.result.NoDataResult;
import com.wt.courseselectionsystem.dao.CourseDao;
import com.wt.courseselectionsystem.model.dao.basebean.Course;
import com.wt.courseselectionsystem.model.vo.request.course.CourseAddForm;
import com.wt.courseselectionsystem.model.vo.request.course.CourseListQuery;
import com.wt.courseselectionsystem.model.vo.request.course.CourseUpdateForm;
import com.wt.courseselectionsystem.model.vo.response.CourseListVo;
import com.wt.courseselectionsystem.model.vo.response.CourseVo;
import com.wt.courseselectionsystem.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author HY
 */
@Service
public class CourseServiceImpl implements CourseService {

    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    private final CourseDao courseDao;

    @Override
    public NoDataResult addCourse(CourseAddForm form) {
        if (!Objects.isNull(courseDao.selectByCourseNo(form.getCourseNo()))) {
            return ResultUtils.fail("课程编号重复");
        }
        Course course = new Course();
        BeanUtils.copyProperties(form, course);
        int rows = courseDao.insertCourse(course);
        if (rows == 1) {
            return ResultUtils.success("添加成功");
        } else {
            return ResultUtils.fail("添加失败");
        }
    }

    @Override
    public DataResult<CourseListVo> list(CourseListQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<Course> list = courseDao.selectCourseInfo(query);
        PageInfo<Course> info = new PageInfo<>(list);
        CourseListVo result = new CourseListVo();
        result.setList(SystemUtils.easyCopy(list, CourseVo.class));
        SystemUtils.configPageInfo(result, info);
        return ResultUtils.success(result);
    }

    @Override
    public NoDataResult update(CourseUpdateForm form) {
        Course course = new Course();
        BeanUtils.copyProperties(form, course);
        int rows = courseDao.updateCourseInfo(course);
        if (rows == 1) {
            return ResultUtils.success("修改成功");
        } else {
            return ResultUtils.fail("修改失败");
        }
    }

    @Override
    public DataResult<CourseVo> info(String courseNo) {
        CourseVo courseVo = new CourseVo();
        Course course = courseDao.selectByCourseNo(courseNo);
        BeanUtils.copyProperties(course, courseVo);
        return ResultUtils.success(courseVo);
    }

    @Override
    public NoDataResult delete(String courseNo) {
        int row = courseDao.delete(courseNo);
        if (row == 1) {
            return ResultUtils.success("删除成功");
        } else {
            return ResultUtils.fail("删除失败");
        }
    }
}
