package com.spark.springboot2learning;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


import javax.sql.DataSource;

/**
 * @author initiald0824
 */
@SpringBootApplication(scanBasePackages = "com.spark.springboot2learning.chap13")
@EnableScheduling
public class Springboot2LearningApplication {

    /**
     * 启动切面
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Springboot2LearningApplication.class, args);
    }
}
