package com.spark.springboot2learning.chap4.intercept;

import com.spark.springboot2learning.chap4.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @author initiald0824
 * @date 2019/8/1 23:09
 */
public interface Interceptor {
    /**
     * 事前方法
     * @return
     */
    public boolean before();

    /**
     * 事后方法
     */
    public void after();

    /**
     * 取代原有事件方法
     * @param invocation -- 回调参数，通过他的proceed方法，回调原有事件
     * @return 原有事件返回对象
     * @throws InvocationTargetException
     * @throws IllegalAccessError
     */
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

    /**
     * 是否返回方法，事件没有发生异常执行
     */
    public void afterReturning();

    /**
     * 事后异常方法，当事件发生异常后执行
     */
    public void afterThrowing();

    /**
     * 是否使用around方法取代原有方法。
     * @return
     */
    boolean useAround();
}
