package com.example.demo.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisListener {
    @Autowired
    StringRedisTemplate template;
    public void receiveMessage(String message){
        //template.
        System.out.println(message);
    }
}

