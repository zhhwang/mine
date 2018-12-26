package com.botany.mint.design.builder;

/**
 * @author wangzh
 */
public class Director {

    public void direct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }
}
