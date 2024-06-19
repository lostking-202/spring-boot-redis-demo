package com.example.demo.controller;

import com.example.demo.service.KeyDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("key")
public class KeyDemoController {

    @Autowired
    KeyDemoService keyDemoService;

    @GetMapping("patternKey")
    public Set<String> patternKey(String pattern){
        return keyDemoService.patternKey(pattern);
    }

    @GetMapping("patternKeyDetail")
    public void patternKeyDetail(String pattern){
        Set<String> keys=keyDemoService.patternKey(pattern);
        keys.stream().forEach(key->System.out.println("key is "+key+" and DataType is "+keyDemoService.type(key)));
    }
}
