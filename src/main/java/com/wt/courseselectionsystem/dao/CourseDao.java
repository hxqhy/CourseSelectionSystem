package com.wt.courseselectionsystem.dao;



import com.wt.courseselectionsystem.model.dao.basebean.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
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

}
