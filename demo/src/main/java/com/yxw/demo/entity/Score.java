package com.yxw.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name="t_score")
@Entity
@Data
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 成绩
     */
    private int score;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Teacher teacher;


}
