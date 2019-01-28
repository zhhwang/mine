package com.botany.mint.design.bridge;

/**
 * @author wangzh
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("draw red circle!");
    }
}
