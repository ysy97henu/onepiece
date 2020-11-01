package com.yinsy.onepiece.redisUtil.controller;

import com.yinsy.onepiece.common.base.BaseResponse;
import com.yinsy.onepiece.redisUtil.service.RedisDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("redis")
public class RedisTestController {

    @Autowired
    private RedisDemoService redisDemoService;

    @GetMapping("spring/cache/save")
    public BaseResponse saveRedisSpringAnnotation(String role){
        return new BaseResponse(redisDemoService.redisSpringAnnotation(role, "test2"));
    }

    @GetMapping("spring/cache/get")
    public BaseResponse getRedisSpringAnnotation(String key){
        return new BaseResponse(redisDemoService.getCacheVerify(key));
    }
}
