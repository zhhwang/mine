package com.botany.mint.design.responsibilityChain.handler.impl;

import com.botany.mint.design.responsibilityChain.student.IStudent;
import com.botany.mint.design.responsibilityChain.handler.AbstractHandler;

/**
 * 班长
 */
public class SquadLeaderHandler extends AbstractHandler {
    public SquadLeaderHandler() {
        super(0);
    }

    protected void process(IStudent student) {
        System.out.println("班长 批复：" + student.getRequestMessage());
    }
}
