package com.example.demo.util;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class RedisDistributedLock {

    RedisTemplate redisTemplate=new RedisTemplate();
    final String LOCK_KEY="distributeLock";

    final String INSTANCE_ID="abc";
    final long TIMEOUT=30L;

    public boolean tryLockAndDoSomething(){
        if(tryLock()){
            doSomething();
            return tryUnlock();
        }
        return false;
    }
    public void doSomething(){
        //设置守护线程，防止事情没做完锁就过期了
        Thread daemonThread= new Thread(() -> {
            //加时间,设置每25s重置过期时间
            try{
                while(true){
                    Thread.sleep(25000);
                    redisTemplate.expire(LOCK_KEY,TIMEOUT, TimeUnit.SECONDS);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        Thread t2= new Thread(() -> {
            //doSomething
        });
        daemonThread.setDaemon(true);
        t2.start();
        daemonThread.start();
    }
    public boolean tryLock(){
        return redisTemplate.opsForValue().setIfAbsent(LOCK_KEY,INSTANCE_ID,TIMEOUT, TimeUnit.SECONDS);
    }
    public boolean tryUnlock(){
        if(INSTANCE_ID.equals(redisTemplate.opsForValue().get(LOCK_KEY))){
            if(redisTemplate.delete(LOCK_KEY)){
                redisTemplate.convertAndSend("unlock","unlock success");
            }
            return true;
        }
        return false;
    }
}
