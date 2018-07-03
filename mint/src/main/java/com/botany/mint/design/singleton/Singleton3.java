package com.botany.mint.design.singleton;

/**
 * @author wangzh
 */
public class Singleton3 {

    /**
     * getInstance方法第一次被调用的时候，instance实例被创建
     */
    private static volatile Singleton3 instance = null;

    private Singleton3() {}

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
