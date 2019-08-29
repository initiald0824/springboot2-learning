package com.spark.springboot2learning;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


import javax.sql.DataSource;

/**
 * @author initiald0824
 */
@SpringBootApplication(
        scanBasePackages = "com.spark.springboot2learning.chap14",
        exclude={DataSourceAutoConfiguration.class}
        )
@EnableReactiveMongoRepositories(basePackages = "com.spark.springboot2learning.chap14.repository")
public class Springboot2LearningApplication {

    /**
     * 启动切面
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Springboot2LearningApplication.class, args);
    }
}
