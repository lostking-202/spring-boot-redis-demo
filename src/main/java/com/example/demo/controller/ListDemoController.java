package com.example.demo.controller;

import com.example.demo.service.ListDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/list")
public class ListDemoController {
    @Autowired
    ListDemoService listDemoService;
    @GetMapping("/leftPush")
    public Long leftPush(@RequestParam String key,@RequestParam String value){
        return listDemoService.leftPush(key,value);
    }
    @GetMapping("/range")
    public List<String> range(@RequestParam String key, @RequestParam Long start, @RequestParam Long end){
        return listDemoService.range(key,start,end);
    }
    @GetMapping("/set")
    public void set(@RequestParam String key, @RequestParam Long index, @RequestParam String value){
        listDemoService.set(key,index,value);
    }
}
