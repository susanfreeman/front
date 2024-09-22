//package com.ruoyi.system.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.concurrent.TimeUnit;
//
//@Service
//public class RedisService {
//
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
//
//    public void setKeyValue(String key, Object value) {
//        redisTemplate.opsForValue().set(key, value);
//    }
//
//    public void setKeyValueSeconds(String key, Object value,long timeout) {
//        redisTemplate.opsForValue().set(key, value,timeout, TimeUnit.SECONDS);
//    }
//
//    public Object getValueByKey(String key) {
//        return redisTemplate.opsForValue().get(key);
//    }
//
//    public void deleteByKey(String key) {
//        redisTemplate.delete(key);
//    }
//}