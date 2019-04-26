package com.yxw.demo.dto;

import lombok.Data;

@Data
public class TeacherDTO {

    private String teacherName;

    private String courseName;



    private double avgScore;

    private int maxScore;

    private int minScore;

    public TeacherDTO(){};

//    public TeacherDTO (double avgScore,int maxScore,int minScore){
//        this.avgScore=avgScore;
//        this.maxScore=maxScore;
//        this.minScore=minScore;
//
//    };
    public TeacherDTO (String courseName,double avgScore,int maxScore,int minScore){
        this.avgScore=avgScore;
        this.maxScore=maxScore;
        this.minScore=minScore;
        this.courseName=courseName;

    };

    public TeacherDTO (String teacherName,String courseName,double avgScore,int maxScore,int minScore){
        this.avgScore=avgScore;
        this.maxScore=maxScore;
        this.minScore=minScore;
        this.teacherName=teacherName;
        this.courseName=courseName;

    };
}
