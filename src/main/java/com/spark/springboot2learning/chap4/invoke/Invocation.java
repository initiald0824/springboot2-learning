package com.spark.springboot2learning.chap4.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author initiald0824
 * @date 2019/8/2 10:46
 */
public class Invocation {
    private Object[] params;
    private Method method;
    private Object target;

    public Invocation(Object target, Method method, Object[] params) {
        this.target = target;
        this.method = method;
        this.params = params;
    }

    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target, params);
    }
}
