package com.wt.courseselectionsystem.model.vo.request.courseplan;

import com.wt.courseselectionsystem.model.vo.request.base.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xxx
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CoursePlanQuery extends PageRequest {
    /**
     * 课程号
     */
    private String courseNo;
    /**
     * 授课老师编号
     */
    private String teacherNo;
}
