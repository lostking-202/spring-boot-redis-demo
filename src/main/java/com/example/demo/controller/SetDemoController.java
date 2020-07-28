package com.example.demo.controller;

import com.example.demo.service.SetDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
