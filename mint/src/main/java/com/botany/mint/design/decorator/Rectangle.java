package com.botany.mint.design.decorator;

/**
 * @author wangzh
 */
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Draw rectangle!");
    }
}
