package com.wt.courseselectionsystem.model.dao.basebean;

public class CoursePlan {
    //课程id
    private String id;
    //课程计划编号
    private String coursePlanNo;
    //课程号
    private String courseNo;
    //授课老师编号
    private String courseName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoursePlanNo() {
        return coursePlanNo;
    }

    public void setCoursePlanNo(String coursePlanNo) {
        this.coursePlanNo = coursePlanNo;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
