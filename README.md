# spring-boot-redis-demo
spring-boot-redis基本api
2020.08.05 redis实现消息订阅
redis实现分布式锁雏形
缺陷:代码耦合性太强,功能模块划分不清,redis sender和redis listener与业务逻辑掺和在一起
instanceid代表每台机器的唯一标识,这样删除key-value就不会被别的实例误删