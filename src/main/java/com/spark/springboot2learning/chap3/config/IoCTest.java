package com.spark.springboot2learning.chap3.config;


import com.spark.springboot2learning.chap3.scope.pojo.ScopeBean;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author initiald0824
 * @date 2019/8/1 11:42
 */
public class IoCTest {
    private static Logger log = Logger.getLogger(IoCTest.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ScopeBean scopeBean1 = ctx.getBean(ScopeBean.class);
        ScopeBean scopeBean2 = ctx.getBean(ScopeBean.class);
        System.out.println(scopeBean1 == scopeBean2);
    }
}
