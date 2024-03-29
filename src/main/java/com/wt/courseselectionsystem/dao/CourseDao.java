package com.wt.courseselectionsystem.dao;


import com.wt.courseselectionsystem.model.dao.basebean.Course;
import com.wt.courseselectionsystem.model.vo.request.course.CourseListQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xx
 */
@Repository
public interface CourseDao {
    /**
     * 根据课程号获取课程信息
     *
     * @param courseNo 课程号
     * @return ...
     */
    Course selectByCourseNo(String courseNo);

    /**
     * 保存课程信息
     *
     * @param course course
     * @return ...
     */
    int insertCourse(@Param("course") Course course);


    /**
     * 修改课程信息
     *
     * @param course ...
     * @return ...
     */
    int updateCourseInfo(@Param("course") Course course);

    /**
     * 删除信息
     *
     * @param courseNo ...
     * @return ...
     */
    int delete(String courseNo);

    /**
     * 查询课程详情
     *
     * @param query 查询条件
     * @return list
     */
    List<Course> selectCourseInfo(@Param("query") CourseListQuery query);

    /**
     * selectMatchListByNo
     *
     * @param courseNo ...
     * @return java.util.List<com.wt.courseselectionsystem.model.dao.basebean.Course>
     * @date 2023/3/18 17:16
     **/
    List<Course> selectMatchListByNo(@Param("courseNo") String courseNo);
}
