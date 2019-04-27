package com.yxw.demo.controller;

import com.yxw.demo.entity.Course;
import com.yxw.demo.utils.Constant;
import com.yxw.demo.utils.Result;
import com.yxw.demo.utils.ResultUtils;
import com.yxw.demo.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CourseController {

    private static Logger log = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseService courseService;


    @PostMapping("/addCourse")
    public Result<Object> addCourse(@RequestBody Course courseDto){
        Course course=courseService.getById(courseDto.getId());
        if(course!=null){
            log.info("该学科已存在..........");
            return ResultUtils.exist();
        }
        courseService.save(courseDto);
        return ResultUtils.success(null);
    }


}
