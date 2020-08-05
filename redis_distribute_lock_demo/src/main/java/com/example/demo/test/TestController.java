package com.example.demo.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    //如果需要读取yml文件中自定义的配置项,需要被spring容器加载
    @Value("${instance.id}")
    String instanceid;
    @GetMapping("value")
    public String getValue(){
        ReadConfigurationTest test=new ReadConfigurationTest();
        System.out.println(test.instanceid);
        System.out.println(instanceid);
        return test.instanceid;
    }
}
