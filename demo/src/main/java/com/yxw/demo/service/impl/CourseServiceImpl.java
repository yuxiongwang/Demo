package com.yxw.demo.service.impl;

import com.yxw.demo.dao.CourseDAO;
import com.yxw.demo.entity.Course;
import com.yxw.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDAO courseDAO;

    @Override
    @Transactional
    public void save(Course course){
        courseDAO.save(course);
    }

    @Override
    public Course getById(Long courseId){
        Optional<Course> course=courseDAO.findById(courseId);
        if(course!=null){
            return course.get();
        }
        return null;
    }
}
