package com.botany.mint.design.proxy;

import com.botany.mint.design.proxy.dynamic.ProxyHanlder;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    public void staticProxyTest() {
        ProxySubject proxy = new ProxySubject();
        proxy.doSomething();
    }

    @Test
    public void dynamicProxyTest() {
        RealSubject realSubject = new RealSubject();
        Subject proxy = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(), new Class[] {Subject.class}, new ProxyHanlder(realSubject));
        proxy.doSomething();
    }
}
