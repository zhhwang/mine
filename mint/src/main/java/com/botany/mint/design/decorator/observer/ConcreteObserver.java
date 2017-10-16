package com.botany.mint.design.decorator.observer;

/**
 * Created by Administrator on 2017/10/16 0016.
 */
public class ConcreteObserver implements IObserver {
    @Override
    public void update(int status) {
        System.out.print("ConcreteObserver 收到新状态：" + status);
    }
}
