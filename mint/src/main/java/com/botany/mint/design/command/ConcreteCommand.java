package com.botany.mint.design.command;

/**
 * 具体命令类，真实场景会有多个具体命令类
 */
public class ConcreteCommand extends Command {

    public ConcreteCommand (Receiver receiver) {
        super(receiver);
    }

    @Override
    public void executeCommand() {
        receiver.action();
    }
}
