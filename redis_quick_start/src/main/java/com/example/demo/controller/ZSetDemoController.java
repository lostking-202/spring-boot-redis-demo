package com.example.demo.controller;

import com.example.demo.service.ZSetDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController("zset")
public class ZSetDemoController {
    @Autowired
    ZSetDemoService zSetDemoService;

    @GetMapping("addOne")
    public boolean addOne(String key,String value,double score){
        return zSetDemoService.add(key,value,score);
    }

    @GetMapping("range")
    public Set<String> range(String key, long start, long end){
        return zSetDemoService.range(key,start,end);
    }
}
