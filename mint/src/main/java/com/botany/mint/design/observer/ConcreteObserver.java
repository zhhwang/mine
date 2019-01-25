package com.botany.mint.design.observer;

/**
 * @author wangzh
 */
public class ConcreteObserver implements IObserver {
    @Override
    public void update(int status) {
        System.out.print("ConcreteObserver 收到新状态：" + status);
    }
}
