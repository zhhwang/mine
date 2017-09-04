package com.botany.mint.design.responsibilityChain.handler.impl;

import com.botany.mint.design.responsibilityChain.student.IStudent;
import com.botany.mint.design.responsibilityChain.handler.AbstractHandler;

public class TeacherHandler extends AbstractHandler {
    public TeacherHandler() {
        super(1);
    }

    protected void process(IStudent student) {
        System.out.println("老师 批复：" + student.getRequestMessage());
    }
}
