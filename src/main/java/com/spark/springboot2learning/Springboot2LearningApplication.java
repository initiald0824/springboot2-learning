package com.spark.springboot2learning;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author initiald0824
 */
@MapperScan(
        // 指定扫描包
        basePackages = "com.spark.springboot2learning.chap11",
        annotationClass = Mapper.class
)
@EnableCaching
@SpringBootApplication(scanBasePackages= {"com.spark.springboot2learning.chap11"})
public class Springboot2LearningApplication {

    /**
     * 启动切面
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Springboot2LearningApplication.class, args);
    }
}
