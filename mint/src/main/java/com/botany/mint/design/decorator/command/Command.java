package com.botany.mint.design.decorator.command;

public abstract class Command {

    protected Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public abstract void  executeCommand();

}
