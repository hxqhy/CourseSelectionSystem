package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.CourseSelection;
import com.wt.courseselectionsystem.model.dao.exbean.CourseInfoForStudent;
import com.wt.courseselectionsystem.model.dao.exbean.CourseSelectionSituationInfo;
import com.wt.courseselectionsystem.model.dao.exbean.CreditInfo;
import com.wt.courseselectionsystem.model.vo.request.course.select.CourseSelectionSituationQuery;
import com.wt.courseselectionsystem.model.vo.request.course.select.CreditsSummaryQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xxx
 */
@Repository
public interface CourseSelectionDao {

    /**
     * 保存选课信息
     *
     * @param courseSelection courseSelection
     * @return ...
     */
    int insertCourseSelection(@Param("courseSelection") CourseSelection courseSelection);

    /**
     * count by studentNo & courseNo.
     * always return 0 or 1
     *
     * @param studentNo    ...
     * @param coursePlanNo ...
     * @return 0 or 1
     */
    int countByStudentNoAndCoursePlanNo(@Param("studentNo") String studentNo,
                                        @Param("coursePlanNo") String coursePlanNo);

    /**
     * 统计排课选课人数
     *
     * @param coursePlanNo ...
     * @return ...
     */
    int countByCoursePlanNo(@Param("coursePlanNo") String coursePlanNo);

    /**
     * 查询学生学分总和
     *
     * @param studentNo ...
     * @return ...
     */
    Integer selectSumCredit(@Param("studentNo") String studentNo);

    /**
     * 查询学分汇总信息
     *
     * @param query ...
     * @return ...
     */
    List<CreditInfo> selectCreditsSummary(@Param("query") CreditsSummaryQuery query);

    /**
     * 获取选课情况列表
     *
     * @param query ...
     * @return ...
     */
    List<CourseSelectionSituationInfo> selectCourseSelections(@Param("query") CourseSelectionSituationQuery query);

    /**
     * 根据学生编号和课程计划编号删除记录
     *
     * @param coursePlanNo ...
     * @param studentNo    ...
     * @return rows
     */
    int deleteByCoursePlanNoAndStudentNo(@Param("coursePlanNo") String coursePlanNo,
                                         @Param("studentNo") String studentNo);

    /**
     * 查询学生选课列表
     *
     * @param studentNo ...
     * @return list
     */
    List<CourseInfoForStudent> selectCoursePlanInfoByStudentNO(@Param("studentNo") String studentNo);

}
