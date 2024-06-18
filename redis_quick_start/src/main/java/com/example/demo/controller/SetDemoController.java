package com.example.demo.controller;

import com.example.demo.service.SetDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * set 不重复会默认排序
 * zset 会有一个分数,value不能重复，score可以重复，按照score排序
 */

@RestController
@RequestMapping("/set")
public class SetDemoController {
    @Autowired
    SetDemoService setDemoService;
    @GetMapping("/add")
    public Long add(@RequestParam String key,@RequestParam String...values){
        return setDemoService.add(key,values);
    }
    @GetMapping("/move")
    public boolean move(@RequestParam String key,@RequestParam String value,@RequestParam String destKey){
        return setDemoService.move(key,value,destKey);
    }

    @GetMapping("/members")
    public Set<String> members(@RequestParam String key){
        return setDemoService.members(key);
    }
}
