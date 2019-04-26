package com.yxw.demo.service;

import com.yxw.demo.entity.Course;
import org.springframework.stereotype.Service;


@Service
public interface CourseService {


     void save(Course course);

     Course getById(Long courseId);
}
