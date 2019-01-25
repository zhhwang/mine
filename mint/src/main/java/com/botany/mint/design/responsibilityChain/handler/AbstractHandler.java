package com.botany.mint.design.responsibilityChain.handler;


import com.botany.mint.design.responsibilityChain.student.IStudent;

public abstract class AbstractHandler implements IHandler{
    private int status = -1;

    private IHandler nextHandler;

    public AbstractHandler(int status) {
        this.status = status;
    }

    @Override
    public void setNextHandler(IHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(IStudent student) {
        if (student != null) {
            if (this.status == student.getStatus()) {
                this.process(student);
            } else {
                if (this.nextHandler != null) {
                    nextHandler.handleRequest(student);
                }
            }

        }
    }

    protected abstract void process(IStudent student);
}
