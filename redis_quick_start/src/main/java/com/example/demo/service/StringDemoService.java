package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class StringDemoService {

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    public void set(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit){
        redisTemplate.opsForValue().set(key,value,timeout,timeUnit);
    }

    //存入新值并返回旧值
    public String getAndSet(String key,String value){
        return redisTemplate.opsForValue().getAndSet(key,value);
    }

    public String getValue(String key){
        return redisTemplate.opsForValue().get(key);
    }

    //返回拼接后的总长度
    public Integer appendValue(String key,String value){
        return redisTemplate.opsForValue().append(key,value);
    }

    //返回结果进行切分后的部分
    public String get(String key,long start,long end){
        return redisTemplate.opsForValue().get(key,start,end);
    }
}
