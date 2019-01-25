package com.botany.mint.design.template;

/**
 * @author wangzh
 */
public class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Game Cricket initialized!");
    }

    @Override
    void startPlay() {
        System.out.println("Game Cricket started!");
    }

    @Override
    void endPlay() {
        System.out.println("Game Cricket ended!");
    }
}
