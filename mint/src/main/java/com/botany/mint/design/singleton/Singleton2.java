package com.botany.mint.design.singleton;

/**
 * @author wangzh
 */
public class Singleton2 {

    /**
     * getInstance方法第一次被调用的时候，instance实例被创建
     */
    private static Singleton2 instance = null;

    private Singleton2() {}

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
