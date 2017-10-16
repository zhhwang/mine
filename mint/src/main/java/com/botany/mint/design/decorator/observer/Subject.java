package com.botany.mint.design.decorator.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/16 0016.
 */
public class Subject implements ISubject {
    List<IObserver>  iObservers = new ArrayList<>();

    private int status;

    @Override
    public void add(IObserver iObserver) {
        iObservers.add(iObserver);
    }

    @Override
    public void remove(IObserver iObserver) {
        iObservers.remove(iObserver);
    }

    @Override
    public void notifyALL() {
        for (IObserver iObserver : iObservers) {
            iObserver.update(this.status);
        }
    }

    public void setStatus(int status) {
        this.status = status;
        notifyALL();
    }
}
