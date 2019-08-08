package com.spark.springboot2learning.chap7.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.PostConstruct;

/**
 * @author initiald0824
 * @date 2019/8/7 8:12
 */
public class Chap7Main {

    @Autowired
    private RedisTemplate redisTemplate = null;

    /**
     * 设置RedisTemplate的序列化器
     */
    private void initRedisTemplate () {
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
    }

    @PostConstruct
    public void init() {
        initRedisTemplate();
    }


    public static void main(String[] args) {
    }
}
