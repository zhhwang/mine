package com.botany.mint.design.singleton;

/**
 * Created by Administrator on 2017/10/19 0019.
 */
public class Singleton4 {
    private static class Holder {
        static final Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return Holder.instance;
    }
}
