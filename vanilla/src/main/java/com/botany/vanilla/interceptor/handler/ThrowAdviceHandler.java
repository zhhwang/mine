package com.botany.vanilla.interceptor.handler;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * 异常处理器
 * @author wangzh
 */
public class ThrowAdviceHandler implements ThrowsAdvice {

    public void afterThrowing(Method m, Object[] args, Object target, Exception ex) {
        // 异常统一处理
    }
}
