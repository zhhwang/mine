package com.botany.mint.design.responsibilityChain.handler.impl;

import com.botany.mint.design.responsibilityChain.student.IStudent;
import com.botany.mint.design.responsibilityChain.handler.AbstractHandler;

public class SchoolMaterHandler extends AbstractHandler {
    public SchoolMaterHandler() {
        super(2);
    }

    protected void process(IStudent student) {
        System.out.println("校长 批复：" + student.getRequestMessage());
    }
}
