package com.wt.courseselectionsystem.model.vo.request.course;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author xxx
 */
@Data
public class CourseUpdateForm {
    /**
     * 课程号
     */
    @NotBlank(message = "课程号不能为空")
    @Length(max = 6, message = "长度不能超过6位")
    private String courseNo;
    /**
     * 课程名称
     */
    @NotBlank(message = "课程名称不能为空")
    private String courseName;
    /**
     * 学分
     */
    @Max(value = 10,message = "最大学分不能大于10")
    @Min(value = 1,message = "最小学分不能小于1")
    private Integer credit;
    /**
     * 学时
     */
    @Max(value = 24,message = "最大学时不能大于24")
    @Min(value = 10,message = "最小学时不能小于10")
    private Integer courseHours;
    /**
     * 名额
     */
    @Max(value = 120,message = "最大人数不能大于120人")
    @Min(value = 40,message = "最小人数不能小于40人")
    private Integer quota;


}
