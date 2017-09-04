package com.botany.mint.design.responsibilityChain.student.impl;

import com.botany.mint.design.responsibilityChain.student.IStudent;

public class Student implements IStudent {
    private int status = -1;

    private String message;

    public Student(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return this.status;
    }

    public String getRequestMessage() {
        return this.message;
    }
}
