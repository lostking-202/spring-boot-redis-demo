package com.example.demo.controller;

import com.example.demo.service.StringDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/string")
public class StringDemoController {
    @Autowired
    StringDemoService stringDemoService;
    @GetMapping("/set")
    public void set(@RequestParam String key,@RequestParam String value){
        stringDemoService.set(key,value);
    }
    @GetMapping("/append")
    public long append(@RequestParam String key,@RequestParam String value){
        return stringDemoService.appendValue(key,value);
    }
    @GetMapping("/get-limit")
    public String getLimit(@RequestParam String key,@RequestParam long start,@RequestParam long end){
        return stringDemoService.get(key,start,end);
    }
    @GetMapping("/get")
    public String get(@RequestParam String key){
        return stringDemoService.getValue(key);
    }
}
