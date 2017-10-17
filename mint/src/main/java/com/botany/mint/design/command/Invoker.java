package com.botany.mint.design.command;

/**
 * 1. 比较容易升级一个命令队列，
 * 2. 需要的情况下比较容易将命令记入日记
 * 3. 接受请求的一方有权利拒绝请求
 * 4. 控制队列中命令的撤销和重做
 * 5. 添加新的命令类
 * 6. 命令发起者不知道命令具体执行的过程
 */
public class Invoker {

    private Command command;

    public void executeCommand() {
        command.executeCommand();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}

