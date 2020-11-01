package com.yinsy.onepiece.redisUtil.service;

import com.yinsy.onepiece.user.entity.UserInfo;

import java.util.List;

public interface RedisDemoService {

    /**
     * Spring注解测试
     */
    List<UserInfo> redisSpringAnnotation(String role, String string);

    /**
     * 获取缓存验证
     */
    List<UserInfo> getCacheVerify(String key);

}
