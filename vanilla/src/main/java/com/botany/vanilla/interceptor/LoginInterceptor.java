package com.botany.vanilla.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 登录校验拦截器
 * <pre>
 *     1、进入controller前
 *     2、渲染页面前
 *     3、输出页面前
 * </pre>
 *
 * @author wangzh
 */
public class LoginInterceptor implements HandlerInterceptor {

    private List<String> ingores;

    public LoginInterceptor(List<String> ingores) {
        this.ingores = ingores;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        // request中获取用户信息
        // 校验用户信息
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("message" , "hello, world");

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
    }
}
