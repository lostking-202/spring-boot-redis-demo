package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootRedisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisDemoApplication.class, args);
	}

	@Bean
	public RedisTemplate getRedisTemplate(RedisConnectionFactory factory){
		RedisTemplate template=new RedisTemplate();
		template.setConnectionFactory(factory);
		return template;
	}
}
