package com.yxw.demo.service.impl;

import com.yxw.demo.dao.TeacherDAO;
import com.yxw.demo.dto.TeacherDTO;
import com.yxw.demo.entity.Course;
import com.yxw.demo.entity.Score;
import com.yxw.demo.entity.Teacher;
import com.yxw.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;


@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDAO teacherDAO;

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Teacher teacher){
        teacherDAO.save(teacher);
    }
    /**
     * 查询教师
     * @param teacherNo
     */
    @Override
    public Teacher getById(Long teacherNo){
        Optional<Teacher>  teacher=teacherDAO.findById(teacherNo);
        if(teacher!=null){
            return teacher.get();
        }
        return null;
    }

    /**
     * 教师本人成绩
     * @return
     */
    @Override
    public List<TeacherDTO> getCourse(Long teacherId){
        return getResult(teacherId,false);

    }

    /**
     * 学科成绩(学科)
     * @return
     */
    @Override
    public List<TeacherDTO> getCourse() {
        return getResult(null, false);
    }

    /**
     * 学科成绩(教师学科)
     * @return
     */
    public List<TeacherDTO> getCourseAndTeacherName(){
          return getResult(null,true);
    }

    /**
     *
     * @param teacherId
     * @param flag（true:包含教师姓名，false 不包含）
     * @return
     */
    public List<TeacherDTO> getResult(Long teacherId,boolean flag){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TeacherDTO> criteriaQuery = criteriaBuilder.createQuery(TeacherDTO.class);
        Root<Score> root = criteriaQuery.from(Score.class);
        //拼接表
        Join<Course, Score> join = root.join("course", JoinType.LEFT);
        Join<Teacher, Score> join2 = root.join("teacher", JoinType.LEFT);
        if(teacherId!=null){
            criteriaQuery.where(criteriaBuilder.equal(join2.get("id"), teacherId));
        }
       if(flag){
           //拼接搜索字段
           criteriaQuery.multiselect(join2.get("teacherName"),join.get("courseName"),criteriaBuilder.avg(root.get("score")),
                   criteriaBuilder.max(root.get("score")), criteriaBuilder.min(root.get("score")));
           criteriaQuery.groupBy(join2.get("teacherName"));
       }else{
           criteriaQuery.multiselect(join.get("courseName"),criteriaBuilder.avg(root.get("score")),
                   criteriaBuilder.max(root.get("score")), criteriaBuilder.min(root.get("score")));
       }
        //分组
        criteriaQuery.groupBy(join.get("courseName"));
        List<TeacherDTO> list = entityManager.createQuery(criteriaQuery).getResultList();
        return list;
    }
}
