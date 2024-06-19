package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sender")
public class RedisSenderController {
    @Autowired
    StringRedisTemplate template;
    @GetMapping("/{message}")
    public String sendMessage(@PathVariable String message){
        template.convertAndSend("a",message);
        return "success";
    }
}
