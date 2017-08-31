package com.botany.mint.design.proxy;

/**
 * 静态代理
 */
public class ProxySubject implements Subject{
    private static final RealSubject realSubject = new RealSubject();

    public ProxySubject() {
    }

    public void doSomething() {
        realSubject.doSomething();
    }
}
