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
     * @param courseSelection courseSelection
     * @return ...
     */
    int insertCourseSelection(@Param("courseSelection")CourseSelection courseSelection);

}
