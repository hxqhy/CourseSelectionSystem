package com.wt.courseselectionsystem.model.vo.request.teacher;

import com.wt.courseselectionsystem.model.vo.request.base.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xxx
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TeacherListQuery extends PageRequest {
    /**
     * 教师名称
     */
    private String teacherName;
    /**
     * 性别
     */
    private Integer gender;

    /**
     * 是否处于激活状态
     * <p>
     * is active:
     * {@link com.wt.courseselectionsystem.common.constant.AccountConstant#QUERY_ACTIVE_CODE_IS_ACTIVE}
     * <br/>
     * is not active:
     * {@link com.wt.courseselectionsystem.common.constant.AccountConstant#QUERY_ACTIVE_CODE_IS_NO_ACTIVE}
     */
    private Integer active;
}
