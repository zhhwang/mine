package com.botany.mint.jdk.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author wangzh
 * <pre>
 *     1、根据类路径实例化
 * </pre>
 */
public class Reflect {

    private String param;

    private static final String classPath = "com.botany.mint.jdk.reflect.Reflect";

    public Reflect() {

    }

    public Reflect(String param) {
        this.param = param;
    }

    public void sayHello(String name) {
        System.out.println("hello, " + name);
    }

    public void newInstanceByClassPath () throws Exception {
        Class tClass = Class.forName(classPath);
        Constructor constructor = tClass.getConstructor(String.class);
        Reflect reflect = (Reflect) constructor.newInstance("value");
    }

    public void methodInvoke() throws Exception {
        Class tClass = Class.forName(classPath);
        Object reflector = tClass.newInstance();
        Method method = tClass.getMethod("sayHello", String.class);
        method.invoke(reflector, "world" );
    }

    public void proxy() {

    }

}
