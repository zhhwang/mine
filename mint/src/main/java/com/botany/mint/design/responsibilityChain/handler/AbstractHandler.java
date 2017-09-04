package com.botany.mint.design.responsibilityChain.handler;


import com.botany.mint.design.responsibilityChain.student.IStudent;

public abstract class AbstractHandler implements IHandler{
    private int status = -1;

    private IHandler handler;

    public AbstractHandler(int status) {
        this.status = status;
    }

    public void setNextHandler(IHandler handler) {
        this.handler = handler;
    }

    public void handleRequest(IStudent student) {
        if (student != null) {
            if (this.status == student.getStatus()) {
                this.process(student);
            } else {
                if (this.handler != null) {
                    handler.handleRequest(student);
                }
            }

        }
    }

    protected abstract void process(IStudent student);
}
