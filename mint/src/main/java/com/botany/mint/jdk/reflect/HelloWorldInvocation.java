package com.botany.mint.jdk.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wangzh
 */
public class HelloWorldInvocation implements InvocationHandler {
    private Object object;

    public HelloWorldInvocation (Object object) {
        super();
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(object, args);
    }
}
