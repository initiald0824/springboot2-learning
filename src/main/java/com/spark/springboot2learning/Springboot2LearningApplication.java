package com.spark.springboot2learning;

import com.spark.springboot2learning.chap4.aspect.MyAspect;
import com.spark.springboot2learning.chap4.aspect.MyAspect1;
import com.spark.springboot2learning.chap4.aspect.MyAspect2;
import com.spark.springboot2learning.chap4.aspect.MyAspect3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author initiald0824
 */
@SpringBootApplication(scanBasePackages= {"com.spark.springboot2learning.chap5"})
public class Springboot2LearningApplication {

    /**
     * 定义切面
     * @return MyAspect
     */
    @Bean(name = "myAspect")
    public MyAspect initMyAspect() {
        return new MyAspect();
    }

    @Bean(name = "myAspect1")
    public MyAspect1 initMyAspect1() {
        return new MyAspect1();
    }

    @Bean(name = "myAspect2")
    public MyAspect2 initMyAspect2() {
        return new MyAspect2();
    }

    @Bean(name = "myAspect3")
    public MyAspect3 initMyAspect3() {
        return new MyAspect3();
    }

    /**
     * 启动切面
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Springboot2LearningApplication.class, args);
    }
}
