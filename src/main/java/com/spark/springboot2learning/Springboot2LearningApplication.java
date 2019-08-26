package com.spark.springboot2learning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;

/**
 * @author initiald0824
 */
@MapperScan(
        // 指定扫描包
        basePackages = "com.spark.springboot2learning.chap11",
        annotationClass = Repository.class
)
@EnableCaching
@SpringBootApplication(scanBasePackages= {"com.spark.springboot2learning.chap11"})
public class Springboot2LearningApplication {


    @Autowired
    private RedisTemplate redisTemplate = null;

    @PostConstruct
    public void init() {
        initRedisTemplate();
    }

    private void initRedisTemplate() {
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
    }

    /**
     * 启动切面
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Springboot2LearningApplication.class, args);
    }
}
