package com.spark.springboot2learning.chap4.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

/**
 * @author initiald0824
 * @date 2019/8/4 16:44
 */
@Aspect
@Order(2)
public class MyAspect2 {
    @Pointcut("execution (* com.spark.springboot2learning.chap4.aspect.service.impl.UserServiceImpl.manyAspects(..))")
    public void manyAspects() {
    }

    @Before("manyAspects()")
    public void before() {
        System.out.println("MyAspect2 before ......");
    }

    @After("manyAspects()")
    public void after() {
        System.out.println("MyAspect2 after ......");
    }

    @AfterReturning("manyAspects()")
    public void afterReturning() {
        System.out.println("MyAspect2 afterReturning .....");
    }
}
