package com.wt.courseselectionsystem.model.dao.basebean;

/**
 * 学生实体类
 */
public class Student {
    //学生id
    private String id;
    //学生学号
    private String studentNo;
    //学生名称
    private String studentName;
    //性别
    private char gender;
    //班级
    private String studentClass;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
}
