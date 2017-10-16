package com.botany.mint.design.decorator.observer;

/**
 * Created by Administrator on 2017/10/16 0016.
 */
public interface ISubject {

    void add(IObserver iObserver);

    void remove(IObserver iObserver);

    void notifyALL();
}
