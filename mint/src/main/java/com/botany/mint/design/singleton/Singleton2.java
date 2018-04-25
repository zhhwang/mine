package com.botany.mint.design.singleton;

/**
 * Created by Administrator on 2017/10/19 0019.
 */
public class Singleton2 {

    private static Singleton2 instance = null;

    private Singleton2() {}

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
