package com.botany.mint.design.command;

import org.junit.Test;

/**
 * Created by Administrator on 2017/10/16 0016.
 */
public class CommandTest {

    @Test
    public void  commandTest() {
        ConcreteCommand command = new ConcreteCommand(new Receiver());
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.executeCommand();
    }
}
