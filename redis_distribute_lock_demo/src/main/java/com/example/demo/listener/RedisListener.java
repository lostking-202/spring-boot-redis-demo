package com.example.demo.listener;

import com.example.demo.util.RedisDistributedLock;
import org.springframework.stereotype.Component;

@Component
public class RedisListener {
    public void receiveMessage(String message,String channle){
        //template.
        if(message.equals("unlock success")){
            //service.lockDoSomething();
            RedisDistributedLock lock=new RedisDistributedLock();
            lock.tryLockAndDoSomething();
        }
    }
}
