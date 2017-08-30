package com.botany.mint.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description: 返回结果工具类
 */
public class OutDataUtil {

    private static final Log log = LogFactory.getLog(OutDataUtil.class);

    /**
     * 返回响应数据
     * 
     * @param response
     *            http响应
     * @param data
     *            数据类
     */
    public static void outData(HttpServletResponse response, Object data) {
        outData(response, JSON.toJSONString(data));
    }

    /**
     * 返回响应数据
     * 
     * @param response
     *            http响应
     * @param json
     *            json字符串
     */
    public static void outData(HttpServletResponse response, String json) {
        try {
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-type", "application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(json);
            response.flushBuffer();
            // 无需flush和close，Tomcat会帮我处理
        } catch (IOException e) {
            log.error("Return Result Content IO Exception");
        }
    }

    /**
     * 返回响应数据
     * 
     * @param response
     *            http响应
     * @param data
     *            文本
     */
    public static void outDataHtml(HttpServletResponse response, String data) {
        try {
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-type", "text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(data);
            response.flushBuffer();
        } catch (IOException e) {
            log.error("Return Result Content IO Exception");
        }
    }
}
