package com.spark.springboot2learning.chap13.service.impl;

import com.spark.springboot2learning.chap13.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author initiald0824
 * @date 2019/8/28 19:22
 */
@Service
public class AsyncServiceImpl implements AsyncService {
    @Override
    @Async
    public void generateReport() {
        System.out.println("报表线程名称：" + "【" + Thread.currentThread().getName() + "】");
    }
}
