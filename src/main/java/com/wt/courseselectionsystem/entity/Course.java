package com.wt.courseselectionsystem.entity;

/**
 * 课程
 */
public class Course {
    //课程id
    private String id;
    //课程号
    private String courseNo;
    //课程名称
    private String courseName;
    //学分
    private Integer credit;
    //学时
    private Integer courseHours;
    //学生人数
    private String studentNumber;

    public Course() {
    }

    public Course(String id, String courseNo, String courseName, Integer credit, Integer courseHours, String studentNumber) {
        this.id = id;
        this.courseNo = courseNo;
        this.courseName = courseName;
        this.credit = credit;
        this.courseHours = courseHours;
        this.studentNumber = studentNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getCourseHours() {
        return courseHours;
    }

    public void setCourseHours(Integer courseHours) {
        this.courseHours = courseHours;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

}
