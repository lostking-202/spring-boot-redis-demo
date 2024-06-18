package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class ZSetDemoService {
    @Autowired
    RedisTemplate<String,String> redisTemplate;
    public Long add(Map<String,Double> map, String key){
        Set<ZSetOperations.TypedTuple<String>> tuples=new HashSet<>();
        for(Map.Entry<String,Double> entry:map.entrySet()){
            tuples.add(new DefaultTypedTuple<>(entry.getKey(),entry.getValue()));
        }
        return redisTemplate.opsForZSet().add(key,tuples);
    }
    public boolean add(String key,String value,Double score){
        return redisTemplate.opsForZSet().add(key,value,score);
    }
    //返回移除元素的个数
    public Long remove(String key,String...values){
        return redisTemplate.opsForZSet().remove(key,values);
    }
    //返回排名
    public Long rank(String key,String value){
        return redisTemplate.opsForZSet().rank(key,value);
    }
    //截取
    public Set<String> range(String key,Long start,Long end){
        return redisTemplate.opsForZSet().range(key,start,end);
    }
    //返回指定分数区间的元素个数
    public Long count(String key,double min,double max){
        return redisTemplate.opsForZSet().count(key,min,max);
    }
    public Long size(String key){
        return redisTemplate.opsForZSet().size(key);
    }
    public Double score(String key,String value){
        return redisTemplate.opsForZSet().score(key,value);
    }
    public Long removeRange(String key,Long start,Long end){
        return redisTemplate.opsForZSet().removeRange(key,start,end);
    }
    public Cursor<ZSetOperations.TypedTuple<String>> scan(String key){
        return redisTemplate.opsForZSet().scan(key, ScanOptions.NONE);
    }
}
