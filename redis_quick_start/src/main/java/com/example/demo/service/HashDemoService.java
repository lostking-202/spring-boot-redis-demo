package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class HashDemoService {
    @Autowired
    RedisTemplate<String,String> redisTemplate;
    public Long delete(String key,String hashKey){
        return redisTemplate.opsForHash().delete(key,hashKey);
    }
    public boolean hasKey(String key,String hashKey){
        return redisTemplate.opsForHash().hasKey(key,hashKey);
    }
    public Object get(String key,String hashKey){
        return redisTemplate.opsForHash().get(key,hashKey);
    }
    public Set<Object> keys(String key){
        return redisTemplate.opsForHash().keys(key);
    }
    public Long size(String key){
        return redisTemplate.opsForHash().size(key);
    }
    public void putAll(String key, Map<String,String> params){
        redisTemplate.opsForHash().putAll(key,params);
    }
    public void put(String key,String hashKey,String value){
        redisTemplate.opsForHash().put(key,hashKey,value);
    }

    // 获取对象的所有属性，不要key
    public List<Object> values(String key){
        return redisTemplate.opsForHash().values(key);
    }

    public Cursor<Map.Entry<Object,Object>> scan(String key){
        return redisTemplate.opsForHash().scan(key, ScanOptions.NONE);
    }

    public Map<Object,Object> entries(String key){
        return redisTemplate.opsForHash().entries(key);
    }
}
