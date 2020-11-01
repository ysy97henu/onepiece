package com.yinsy.onepiece.redisUtil.service.impl;

import com.yinsy.onepiece.redisUtil.service.RedisDemoService;
import com.yinsy.onepiece.user.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RedisDemoServiceImpl implements RedisDemoService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Cacheable(value = "spring:demo", key = "#role")
    @Override
    public List<UserInfo> redisSpringAnnotation(String role, String string) {
        List<UserInfo> initCacheList = getRedisCache();
        log.debug("get cache key {} data:{}", role, initCacheList);
        return initCacheList;
    }


    @Override
    public List<UserInfo> getCacheVerify(String key) {
        log.debug("cache key:{}", key);
        List<UserInfo> userInfos = (List<UserInfo>) redisTemplate.opsForValue().get(key);
        log.debug("cache verify cache data:{}", userInfos);
        return userInfos;
    }

    /**
     * 获取缓存数据
     */
    private List<UserInfo> getRedisCache() {
        log.debug("get Cache from Remote");
        List<UserInfo> userInfos = new ArrayList<>();
        userInfos.add(new UserInfo(Long.valueOf(1), "1", "ysy", null, null, null));
        userInfos.add(new UserInfo(Long.valueOf(2), "2", "chr", null, null, null));
        userInfos.add(new UserInfo(Long.valueOf(3), "3", "wzz", null, null, null));
        userInfos.add(new UserInfo(Long.valueOf(4), "4", "hhb", null, null, null));
        userInfos.add(new UserInfo(Long.valueOf(1), "1", "ysy", null, null, null));
        return userInfos;
    }
}