package com.yxw.demo.dto;

import lombok.Data;

@Data
public class StudentDTO {


    private String studentName;

    private String courseName;

    private int score;

    public StudentDTO(String studentName,String courseName,int score){
        this.courseName=courseName;
        this.studentName=studentName;
        this.score=score;
    }
}
