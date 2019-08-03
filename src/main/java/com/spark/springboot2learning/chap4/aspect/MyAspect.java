package com.spark.springboot2learning.chap4.aspect;

import org.aspectj.lang.annotation.*;

/**
 * @author initiald0824
 * @date 2019/8/3 15:59
 */
@Aspect
public class MyAspect {

    @Pointcut("execution(* com.spark.springboot2learning.chap4.aspect.service.impl.UserServiceImpl.printUser(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("before ......");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after ......");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning .....");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing ......");
    }
}

