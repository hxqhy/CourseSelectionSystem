package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.CoursePlan;
import com.wt.courseselectionsystem.model.dao.exbean.CoursePlanInfo;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanInfoQuery;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xxx
 */
@Repository
public interface CoursePlanDao {
    
    /**
     * 保存信息
     *
     * @param coursePlan coursePlan
     * @return ...
     */
    int insertCoursePlan(@Param("coursePlan") CoursePlan coursePlan);

    /**
     * 课程计划条件查询
     *
     * @param query ...
     * @return ...
     */
    List<CoursePlan> select(@Param("query") CoursePlanQuery query);

    /**
     * 修改课程信息
     *
     * @param coursePlan ...
     * @return ...
     */
    int updateInfo(@Param("coursePlan") CoursePlan coursePlan);

    /**
     * 删除信息
     *
     * @param coursePlanNo ...
     * @return ...
     */
    int delete(String coursePlanNo);

    /**
     * 查询排课详情信息
     *
     * @param query 查询条件
     * @return list
     */
    List<CoursePlanInfo> selectCoursePlanInfo(@Param("query") CoursePlanInfoQuery query);

    /**
     * 根据课程计划号获取课程计划信息
     *
     * @param coursePlanNo 课程计划编码
     * @return ...
     */
    CoursePlanInfo selectInfoByCoursePlanNo(String coursePlanNo);
}
