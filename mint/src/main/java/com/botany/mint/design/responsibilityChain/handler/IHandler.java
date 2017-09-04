package com.botany.mint.design.responsibilityChain.handler;

import com.botany.mint.design.responsibilityChain.student.IStudent;

public interface IHandler {

    void setNextHandler(IHandler iHandler);

    void handleRequest(IStudent iStudent);
}
