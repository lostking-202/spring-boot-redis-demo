package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class KeyDemoService {
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    public boolean hasKey(String key){
        return redisTemplate.hasKey(key);
    }
    public void renamekey(String oldKey,String newKey){
        redisTemplate.rename(oldKey,newKey);
    }
    public boolean renameIfAbsent(String oldKey,String newKey){
        return redisTemplate.renameIfAbsent(oldKey,newKey);
    }
    public boolean deleteKey(String key){
        return redisTemplate.delete(key);
    }
    public long deleteKeys(List<String> keys){
        return redisTemplate.delete(keys);
    }
    public boolean expireKey(String key, long time, TimeUnit timeUnit){
        return redisTemplate.expire(key,time,timeUnit);
    }
    public boolean expireKeyAt(String key, Date date){
        return redisTemplate.expireAt(key,date);
    }
    public long getKeyExpire(String key,TimeUnit timeUnit){
        return redisTemplate.getExpire(key,timeUnit);
    }

    //Redis PERSIST 命令用于移除给定 key 的过期时间，使得 key 永不过期。
    public boolean persistKey(String key){
        return redisTemplate.persist(key);
    }

    //查找所有符合条件的key
    public Set<String> patternKey(String pattern){
        return redisTemplate.keys(pattern);
    }

    //查看key的类型
    public DataType type(String key){
        return redisTemplate.type(key);
    }
}
