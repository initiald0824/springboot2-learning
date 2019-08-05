package com.spark.springboot2learning.chap5.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

/**
 * @author initiald0824
 * @date 2019/8/5 21:03
 */
@Intercepts({
        @Signature(type = StatementHandler.class,
        method = "prepare",
        args = { Connection.class, Integer.class })
})
public class MyPlugin implements Interceptor {
    Properties properties = null;


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("插件拦截方法......");
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
