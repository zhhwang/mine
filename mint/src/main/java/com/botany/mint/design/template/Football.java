package com.botany.mint.design.template;

/**
 * @author wangzh
 */
public class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Game Football initialized!");
    }

    @Override
    void startPlay() {
        System.out.println("Game Football started!");
    }

    @Override
    void endPlay() {
        System.out.println("Game Football ended!");
    }
}
