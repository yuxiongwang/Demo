package com.yxw.demo.dao;

import com.yxw.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherDAO extends JpaRepository<Teacher,Long>, JpaSpecificationExecutor<Teacher> {

}
