package com.yxw.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name="t_teacher")
@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 教师类型 0：普通老师，1：主任
     */
    private int status;




}
