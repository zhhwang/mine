package com.botany.mint.design.observer;

import com.botany.mint.design.decorator.observer.ConcreteObserver;
import com.botany.mint.design.decorator.observer.Subject;
import org.junit.Before;

/**
 * Created by Administrator on 2017/10/16 0016.
 */
public class ObserverTest {

    @Before
    public void observerTest() {
        ConcreteObserver observer1 = new ConcreteObserver();

        Subject subject = new Subject();
        subject.add(observer1);

        subject.setStatus(1);
    }
}
