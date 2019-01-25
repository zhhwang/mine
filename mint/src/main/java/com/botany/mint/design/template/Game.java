package com.botany.mint.design.template;

/**
 * @author wangzh
 */
public abstract class Game {

    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    public final void play() {
        // 初始化游戏
        initialize();

        // 开始游戏
        startPlay();

        // 结束游戏
        endPlay();
    }
}
