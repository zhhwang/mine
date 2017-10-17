package com.botany.mint.jdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * 1. 函数式接口
 * 2. 匿名内部类
 * 3. 可参考链接： http://www.cnblogs.com/franson-2016/p/5593080.html
 */
public class Lambda {
    Callable<String> helloCallable (String name) {
        final String hello = "Hello";
        return () -> (hello + "," + name);
    }

    void lambdaList () {
        final int[] sum = {0};
        List<Long> list = new ArrayList();
        list.add(2L);
        list.add(3L);
        list.forEach(e -> { sum[0] += e.intValue();});
        list.forEach(e -> { sum[0] += e.intValue();});
    }

    void lambda () {
        Comparator<String> c = (String s1, String s2) -> s1.compareTo(s2);

        Lambda[] lambdas = new Lambda[5];
        Arrays.sort(lambdas, Lambda::compareByAge);

        Block<Integer> b1 = System :: exit;
        Block<String[]> b2 = Arrays :: sort;
        Block<String> b3 = Lambda :: main;
        Runnable r = Lambda :: main;
    }

    public Runnable toDoLater() {
        return () -> { System.out.println("later");};
    }

    public static int compareByAge(Lambda a, Lambda b) {
        return 0;
    }

    public static void main(String... args) {
    }
}
