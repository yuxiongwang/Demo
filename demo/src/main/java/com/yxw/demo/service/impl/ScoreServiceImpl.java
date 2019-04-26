package com.yxw.demo.service.impl;

import com.yxw.demo.dao.ScoreDAO;
import com.yxw.demo.entity.Score;
import com.yxw.demo.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreDAO scoreDAO;

    @Override
    @Transactional
    public void save(Score course){
        scoreDAO.save(course);
    }


}
