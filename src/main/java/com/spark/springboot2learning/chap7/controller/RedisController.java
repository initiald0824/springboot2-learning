package com.spark.springboot2learning.chap7.controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author initiald0824
 * @date 2019/8/8 11:16
 */
@RestController
@RequestMapping("/redis")
public class RedisController implements InitializingBean {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @RequestMapping("/multi")
    public Map<String, Object> testMulti() {
        redisTemplate.opsForValue().set("key1", "1");
        List list = (List) redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                // 设置监控key1
                redisOperations.watch("key1");
                redisOperations.opsForValue().set("key1", "value1");
                // 开启事务，在exec命令执行前，全部都只是进入队列
                redisOperations.multi();
                redisOperations.opsForValue().set("key2", "value2");
                Object value2 = redisOperations.opsForValue().get("key2");
                System.out.println("命令在队列，所以value为null 【" + value2 + "】");
                redisOperations.opsForValue().set("key3", "value3");
                Object value3 = redisOperations.opsForValue().get("key3");
                System.out.println("命令在队列，所以value为null【" + value3 + "】");
                return redisOperations.exec();
            }
        });
        System.out.println(list);
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        redisTemplate.setKeySerializer(redisTemplate.getStringSerializer());
        redisTemplate.setValueSerializer(redisTemplate.getStringSerializer());
    }
}
