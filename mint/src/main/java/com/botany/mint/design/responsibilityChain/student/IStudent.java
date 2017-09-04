package com.botany.mint.design.responsibilityChain.student;

/**
 * 学生请假demo
 */
public interface IStudent {
    /**
     * 获得学生请假状态
     * 0：小事（班长就可以处理）
     * 1：班长处理不了，老师能处理的事
     * 2：老师处理不了，校长能处理的事
     */
    int getStatus();

    String getRequestMessage();
}
