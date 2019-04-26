package com.yxw.demo.dao;


import com.yxw.demo.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreDAO extends JpaRepository<Score,Long> , JpaSpecificationExecutor<Score> {

}
