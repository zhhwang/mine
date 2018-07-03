package com.botany.mint.design.singleton;

/**
 * @author wangzh
 */
public class Singleton4 {
    /**
     * 类Singleton4初始化之后，Holder会初始化，instance实例会被创建
     */
    private static class Holder {
        static final Singleton4 instance = new Singleton4();
    }

    private Singleton4() {}

    public static Singleton4 getInstance() {
        return Holder.instance;
    }
}
