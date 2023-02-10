package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.CoursePlan;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author xxx
 */
@Repository
public interface CoursePlanDao {
    /**
     * 根据课程计划号获取课程计划信息
     *
     * @param coursePlanNo 课程计划编码
     * @return ...
     */
    CoursePlan selectByCoursePlan(String coursePlanNo);
    /**
     * 保存信息
     *
     * @param coursePlan coursePlan
     * @return ...
     */
    int insertCoursePlan(@Param("coursePlan")CoursePlan coursePlan);
}
