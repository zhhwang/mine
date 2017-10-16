package com.botany.mint.design.decorator.command;

/**
 * Created by Administrator on 2017/10/16 0016.
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
