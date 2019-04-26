package com.yxw.demo.service;

import com.yxw.demo.dto.StudentDTO;
import com.yxw.demo.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;



@Service
public interface StudentService {

    Page<StudentDTO> findMyScore(int index, int pageSize,Long studentId);

    Student findById(Long studentId);

    void save(Student student);

}
