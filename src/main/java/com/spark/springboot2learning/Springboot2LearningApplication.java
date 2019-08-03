package com.spark.springboot2learning;

import com.spark.springboot2learning.chap4.aspect.MyAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author initiald0824
 */
@SpringBootApplication(scanBasePackages= {"com.spark.springboot2learning.chap4.aspect"})
public class Springboot2LearningApplication {

    /**
     * 定义切面
     * @return MyAspect
     */
    @Bean(name = "myAspect")
    public MyAspect initMyAspect() {
        return new MyAspect();
    }

    /**
     * 启动切面
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Springboot2LearningApplication.class, args);
    }
}
