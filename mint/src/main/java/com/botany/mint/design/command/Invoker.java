package com.botany.mint.design.command;

import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 命令管理器
 */
public class Invoker {
    // 命令队列
    private List<Command> commandList;

    // 添加命令
    public Invoker addCommand(Command command) {
        this.commandList.add(command);
        return this;
    }

    // 执行命令
    public void executeCommandList() {
        if (CollectionUtils.isEmpty(commandList)) {
            System.out.println("无任何命令可执行");
        }
        commandList.forEach(c -> c.executeCommand());
    }
}

