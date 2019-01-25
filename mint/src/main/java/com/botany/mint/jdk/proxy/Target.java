package com.botany.mint.jdk.proxy;

/**
 * @author wangzh
 */
public class Target implements ITarget {

    @Override
    public void doSomethingBad(String hah) {
        System.out.println("something bad i wanna do");
    }

    @Override
    public void doSomething() {
        System.out.println("something i wanna do");
    }
}
