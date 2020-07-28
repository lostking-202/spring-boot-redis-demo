package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class SetDemoService {
    @Autowired
    RedisTemplate<String,String> redisTemplate;
    public Long add(String key,String...values){
        return redisTemplate.opsForSet().add(key,values);
    }
    public Long remove(String key,String...values){
        return redisTemplate.opsForSet().remove(key,values);
    }
    //移除一个随机元素并返回
    public String pop(String key){
        return redisTemplate.opsForSet().pop(key);
    }
    //不可从set移动到list
    public boolean move(String key,String value,String destKey){
        return redisTemplate.opsForSet().move(key,value,destKey);
    }
    public Long size(String key){
        return redisTemplate.opsForSet().size(key);
    }
    public Set<String> members(String key){
        return redisTemplate.opsForSet().members(key);
    }
    public Cursor<String> scan(String key){
        return redisTemplate.opsForSet().scan(key, ScanOptions.NONE);
    }
}
