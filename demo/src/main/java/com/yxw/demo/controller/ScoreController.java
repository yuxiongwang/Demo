package com.yxw.demo.controller;

import com.yxw.demo.entity.Score;
import com.yxw.demo.utils.Result;
import com.yxw.demo.utils.ResultUtils;
import com.yxw.demo.service.ScoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ScoreController {

    private static Logger log = LoggerFactory.getLogger(ScoreController.class);

    private ScoreService scoreService;


    @PostMapping("/addScore")
    public Result<Object> addScore(@RequestBody Score scoreDto){
        scoreService.save(scoreDto);
        return ResultUtils.success(null);
    }
}
