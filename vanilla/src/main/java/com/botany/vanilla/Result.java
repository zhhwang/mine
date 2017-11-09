package com.botany.vanilla;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangzh.
 */
public class Result {

    private int code;

    private String message;

    private Map<String, Object> data = new HashMap<String , Object>(16);

    public Result() {
    }
    public Result(String message) {
        this.message = message;
    }


    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void put(String key, Object value) {
        data.put(key, value);
    }
}
