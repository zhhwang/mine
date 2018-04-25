package com.botany.mint.design.singleton;

/**
 * @author wangzh
 */
public class Singleton {

    private static final Singleton instance = new Singleton();

    /**
     * 私有构造器，禁止外部访问
     */
    private Singleton() {}

    // 静态工厂方法
    public static Singleton getInstance() {
        return instance;
    }
}
