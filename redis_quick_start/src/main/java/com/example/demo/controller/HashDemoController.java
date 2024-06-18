package com.example.demo.controller;

import com.example.demo.service.HashDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController("hash")
public class HashDemoController {

    @Autowired
    HashDemoService hashDemoService;

    @GetMapping("put")
    public void put(String key, String hashKey, String value){
        hashDemoService.put(key,hashKey,value);
    }

    @GetMapping("getObject")
    public Map<Object,Object> getObject(String key){
        return hashDemoService.entries(key);
    }

    @GetMapping("values")
    public List<Object> values(String key){
        return hashDemoService.values(key);
    }
}
