package com.yxw.demo.service;


import com.yxw.demo.dto.TeacherDTO;
import com.yxw.demo.entity.Teacher;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public interface TeacherService {



     void save(Teacher teacher);
    /**
     * 查询教师
     * @param teacherNo
     */
     Teacher getById(Long teacherNo);

    /**
     * 教师本人成绩
     * @return
     */

     List<TeacherDTO> getCourse(Long teacherId);

    /**
     * 学科成绩(学科)
     * @return
     */

     List<TeacherDTO> getCourse();

    /**
     * 学科成绩(教师学科)
     * @return
     */
     List<TeacherDTO> getCourseAndTeacherName();

}
