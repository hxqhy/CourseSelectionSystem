package com.wt.courseselectionsystem.model.dao.basebean;

public class CourseSelection {
    private String id;
    //课程计划编号
    private String coursePlanNo;
    //学生学号
    private String studentNo;

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

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }
}
