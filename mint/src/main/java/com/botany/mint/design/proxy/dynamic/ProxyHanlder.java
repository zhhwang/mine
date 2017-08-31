package com.botany.mint.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 * <p>在一些有共同特征(比如方法名都以“get”开头)的方法前或方法后执行其他功能或令其不执行</p>
 * <p>不需要修改源码，不需要提前实例化</p>
 * <p>应用;Spring AOP</p>
 */
public class ProxyHanlder implements InvocationHandler {
    private Object proxied;

    public ProxyHanlder(Object proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // do something before realSubject
        return method.invoke(proxied, args);
        // do something after realSubject
    }
}
