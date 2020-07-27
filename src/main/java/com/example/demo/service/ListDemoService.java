package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
//https://blog.csdn.net/javaxiaibai0414/article/details/88666453
@Service
public class ListDemoService {
    @Autowired
    RedisTemplate<String,String> redisTemplate;
    public Long size(String key){
        return redisTemplate.opsForList().size(key);
    }
    //插入头部,返回list的size
    public Long leftPush(String key,String value){
        return redisTemplate.opsForList().leftPush(key,value);
    }
    //截取指定索引范围的元素集并返回
    public List<String> range(String key,long start,long end){
        return redisTemplate.opsForList().range(key,start,end);
    }
    //插入尾部,返回list的size
    public Long rigthPush(String key,String value){
        return redisTemplate.opsForList().rightPush(key,value);
    }
    //在指定索引位置插入元素,只能插入已有位置并替换元素
    public void set(String key,long index,String value){
        redisTemplate.opsForList().set(key,index,value);
    }
    //删除count个指定key中出现的value,count>0,从头到尾查找删除,count<0,从尾到头查找删除,count=0,删除所有指定value的元素
    public Long remove(String key,Long count,String value){
        return redisTemplate.opsForList().remove(key,count,value);
    }
    //查找指定索引位置的元素
    public String index(String key,Long index){
        return redisTemplate.opsForList().index(key,index);
    }
    //弹出指定key中最左边的元素,弹出后该值在列表中不复存在
    public String leftPop(String key){
        return redisTemplate.opsForList().leftPop(key);
    }
    //弹出指定key中最右边的元素,弹出后该值在列表中不复存在
    public String rightPop(String key){
        return redisTemplate.opsForList().rightPop(key);
    }
}
