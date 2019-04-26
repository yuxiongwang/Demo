package com.yxw.demo.service;

import com.yxw.demo.entity.Score;
import org.springframework.stereotype.Service;

@Service
public interface ScoreService {

     void save(Score course);

}
