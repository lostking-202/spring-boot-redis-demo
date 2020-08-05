package com.example.demo;

import com.example.demo.listener.RedisListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@SpringBootApplication
public class LockDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LockDemoApplication.class, args);
	}

	@Bean
	RedisMessageListenerContainer getRedisMessageListenerContainer(RedisConnectionFactory factory, MessageListenerAdapter adapter){
		RedisMessageListenerContainer container=new RedisMessageListenerContainer();
		container.setConnectionFactory(factory);
		container.addMessageListener(adapter,new PatternTopic("unlock"));
		return container;
	}

	@Bean
	MessageListenerAdapter getMessageListenerAdapter(RedisListener listener){
		return new MessageListenerAdapter(listener,"receiveMessage");
	}

}
