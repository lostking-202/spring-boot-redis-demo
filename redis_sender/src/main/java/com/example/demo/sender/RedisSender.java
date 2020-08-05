package com.example.demo.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

public class RedisSender {
    @Autowired
    StringRedisTemplate redisTemplate;
    public void send(String message){
        redisTemplate.convertAndSend("a",message);
    }
}
