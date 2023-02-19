package com.wt.courseselectionsystem.model.vo.request.course.select;

import com.wt.courseselectionsystem.model.vo.request.base.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lixin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CourseSelectionSituationQuery extends PageRequest {

    /**
     * 学号
     */
    private String studentNo;

    private String studentName;

    private String studentClass;
    
    private String courseName;

}
