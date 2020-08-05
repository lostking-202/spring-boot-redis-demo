package com.example.demo.test;

import org.springframework.beans.factory.annotation.Value;

public class ReadConfigurationTest {
    @Value("${instance.id}")
    String instanceid;
}
