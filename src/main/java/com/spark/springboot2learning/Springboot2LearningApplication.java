package com.spark.springboot2learning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;

/**
 * @author initiald0824
 */
@MapperScan(
        // 指定扫描包
        basePackages = "com.spark.springboot2learning.chap6",
        annotationClass = Repository.class
)
@SpringBootApplication(scanBasePackages= {"com.spark.springboot2learning.chap6"})
public class Springboot2LearningApplication {

    @Autowired
    PlatformTransactionManager transactionManager = null;

    @PostConstruct
    public void viewTransactionManager() {
        System.out.println(transactionManager.getClass().getName());
    }

    /**
     * 启动切面
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Springboot2LearningApplication.class, args);
    }
}
