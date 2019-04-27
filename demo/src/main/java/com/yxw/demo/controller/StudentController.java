package com.yxw.demo.controller;

import com.yxw.demo.entity.Student;
import com.yxw.demo.utils.Constant;
import com.yxw.demo.utils.Result;
import com.yxw.demo.utils.ResultUtils;
import com.yxw.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {

    private static Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;
    /**
     *查询学生分数
     */
    @GetMapping("/getMyScore")
    public Result<Object> getMyScore(int index,int pageSize,Long studentId){
        log.info("请求参数：studentNo："+studentId+",index:"+index+",pageSize:"+pageSize);
        if(studentId==null){
            log.info(Constant.NO_PARAMETER);
            return ResultUtils.lack();
        }
        Student stu=studentService.findById(studentId);
        if(null==stu){
            return ResultUtils.fail();
        }
        return ResultUtils.success(studentService.findMyScore(index,pageSize,studentId));
    }

    @PostMapping("/addStudent")
    public Result<Object> addStudent(@RequestBody Student studentDto){
        Student stu=studentService.findById(studentDto.getId());
        if(stu!=null){
            log.info("该学生已存在..........");
            return ResultUtils.exist();
        }
        studentService.save(studentDto);
        return ResultUtils.success(null);
    }

}
