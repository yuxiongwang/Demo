package com.yxw.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name="t_student")
@Entity
@Data//lombok注解
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 學生姓名
     */
    private String studentName;


}
