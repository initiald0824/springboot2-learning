package com.spark.springboot2learning.chap4.aspect;

import com.spark.springboot2learning.chap3.pojo.User;
import com.spark.springboot2learning.chap4.aspect.validator.UserValidator;
import com.spark.springboot2learning.chap4.aspect.validator.impl.UserValidatorImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

/**
 * @author initiald0824
 * @date 2019/8/3 15:59
 */
@Aspect
public class MyAspect {

    @DeclareParents(value = "com.spark.springboot2learning.chap4.aspect.service.impl.UserServiceImpl",
                    defaultImpl = UserValidatorImpl.class)
    public UserValidator userValidator;

    @Pointcut("execution(* com.spark.springboot2learning.chap4.aspect.service.impl.UserServiceImpl.printUser(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("before ......");
    }

    @Before("pointCut() && args(user)")
    public void beforeParam(User user) {
        System.out.println("before params.... " + user.getUserName());
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

    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around before ......");
        jp.proceed();
        System.out.println("around after ......");
    }

}

