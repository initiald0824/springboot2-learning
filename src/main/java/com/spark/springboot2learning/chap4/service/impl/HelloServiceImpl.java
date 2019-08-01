package com.spark.springboot2learning.chap4.service.impl;

/**
 * @author initiald0824
 * @date 2019/8/1 22:59
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        if (name == null || "".equals(name.trim())) {
            throw new RuntimeException("parameter is null!");
        }
        System.out.println("hello " + name);
    }
}
