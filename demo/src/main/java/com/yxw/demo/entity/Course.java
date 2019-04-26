package com.yxw.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Table(name="t_course")
@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 学科名称
     */
    private String courseName;




}
