create database course_selection_system;

use course_selection_system;

create table account
(
    id           int auto_increment primary key,
    account_no   char(13)     not null comment '账号',
    password     varchar(100) not null comment '密码',
    account_type int          not null comment '用户类型,0:管理员，1:学生，2:教师',
    unique index account_no_index (account_no)
) comment '账号表';

create table student
(
    id            int auto_increment primary key,
    student_no    char(12)    not null comment '学号',
    student_name  varchar(10) not null comment '学生姓名',
    gender        int         not null comment '性别 1:男；0:女',
    student_class varchar(20) not null comment '班级',
    unique index student_no_index (student_no)
) comment '学生信息表';

create table teacher
(
    id           int auto_increment primary key,
    teacher_no   char(12)    not null comment '教师编号',
    teacher_name varchar(10) not null comment '教师姓名',
    gender       int         not null comment '性别 1:男；0:女',
    unique index student_no_index (teacher_no)
) comment '教师信息表';

create table course
(
    id             int auto_increment primary key,
    course_no      char(6)     not null comment '课程号',
    course_name    varchar(20) not null comment '课程名称',
    credit         int         not null comment '学分',
    course_hours   int         not null comment '学时',
    student_number int         not null comment '学生人数',
    unique index course_no_index (course_no)
) comment '课程信息表';

create table course_plan
(
    id             int auto_increment primary key,
    course_plan_no char(22) not null comment '课程计划编号，course_no + teacher_no + 开课年份',
    course_no      char(6)  not null comment '课程号',
    teacher_no     char(12) not null comment '授课老师编号',
    year           char(4)  not null comment '开课年份',
    unique index course_no_index (course_plan_no)
) comment '课程计划表';

create table course_selection
(
    id             int auto_increment primary key,
    student_no     char(12) not null comment '学生编号',
    course_plan_no char(22) not null comment '课程计划编号'
) comment '选课表';


