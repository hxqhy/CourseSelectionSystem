package com.wt.courseselectionsystem.dao;

import com.wt.courseselectionsystem.model.dao.basebean.CourseSelection;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
}
