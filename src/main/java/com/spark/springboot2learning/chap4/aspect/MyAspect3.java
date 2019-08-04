package com.spark.springboot2learning.chap4.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

/**
 * @author initiald0824
 * @date 2019/8/4 16:49
 */
@Aspect
@Order(1)
public class MyAspect3 {
    @Pointcut("execution(* com.spark.springboot2learning.chap4.aspect.service.impl.UserServiceImpl.manyAspects(..))")
    public void manyAspects() {
    }

    @Before("manyAspects()")
    public void before() {
        System.out.println("MyAspect3 before ......");
    }

    @After("manyAspects()")
    public void after() {
        System.out.println("MyAspect3 after ......");
    }

    @AfterReturning("manyAspects()")
    public void afterReturning() {
        System.out.println("MyAspect3 afterReturning .....");
    }
}
