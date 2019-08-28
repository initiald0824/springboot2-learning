package com.spark.springboot2learning.chap13.controller;

import com.spark.springboot2learning.chap13.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author initiald0824
 * @date 2019/8/28 19:24
 */
@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/page")
    public String asyncPage() {
        System.out.println("请求线程名称：" + "【" + Thread.currentThread().getName() + "】");
        // 调用异步服务
        asyncService.generateReport();
        return "async";
    }
}
