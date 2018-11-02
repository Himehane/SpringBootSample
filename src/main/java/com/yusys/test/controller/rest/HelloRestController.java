package com.yusys.test.controller.rest;


import com.yusys.test.service.RedisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloRestController{
    @Autowired
    private RedisService redisService;

    @GetMapping("/putInfo/{id}")
    public String SetInfo(@PathVariable String id){
       return redisService.writerRedis(id);
    }
    @GetMapping("/getInfo/{id}")
    public String getRedisInfo(@PathVariable String id){
       return redisService.ReadRedis(id);
    }
}