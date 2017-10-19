package com.botany.mint.design.singleton;

/**
 * Created by Administrator on 2017/10/19 0019.
 */
public class Singleton {

    private static final Singleton instance = new Singleton();

    public  static Singleton getInstance() {
        return instance;
    }

}
