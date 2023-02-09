package com.wt.courseselectionsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lixin
 */
@SpringBootApplication
@MapperScan(value = {"com.wt.courseselectionsystem.dao"})
public class CourseSelectionSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseSelectionSystemApplication.class, args);
    }
    
}
