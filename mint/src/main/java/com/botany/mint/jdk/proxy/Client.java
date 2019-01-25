package com.botany.mint.jdk.proxy;

/**
 * @author wangzh
 */
public class Client {

    public static void main(String[] args) {

        ITarget target = new DynamicProxy(new Target()).getProxy();
        target.doSomething();
        target.doSomethingBad("hah");
    }
}
