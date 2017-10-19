package com.botany.mint.design.singleton;

/**
 * Created by Administrator on 2017/10/19 0019.
 */
public class Singleton3 {
    private static volatile Singleton3 instance = null;
    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
