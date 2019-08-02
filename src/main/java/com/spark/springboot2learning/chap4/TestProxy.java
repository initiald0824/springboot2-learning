package com.spark.springboot2learning.chap4;

import com.spark.springboot2learning.chap4.intercept.MyInterceptor;
import com.spark.springboot2learning.chap4.proxy.ProxyBean;
import com.spark.springboot2learning.chap4.service.impl.HelloService;
import com.spark.springboot2learning.chap4.service.impl.HelloServiceImpl;

/**
 * @author initiald0824
 * @date 2019/8/2 11:04
 */
public class TestProxy {
    private static void testProxy() {
        HelloService helloService = new HelloServiceImpl();
        // 按约定获取proxy
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
        proxy.sayHello("test");
        System.out.println("\n ###### name is null!! #######\n");
        proxy.sayHello(null);
    }

    public static void main(String[] args) {
        testProxy();
    }
}
