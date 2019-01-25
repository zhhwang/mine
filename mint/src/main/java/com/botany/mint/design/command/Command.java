package com.botany.mint.design.command;

/**
 * 命令抽象类
 */
public abstract class Command {

    protected Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public abstract void  executeCommand();

}
