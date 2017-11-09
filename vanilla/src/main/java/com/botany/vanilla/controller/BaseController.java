package com.botany.vanilla.controller;

import com.botany.vanilla.Result;
import com.botany.vanilla.exception.CommonException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 拦截这个类里抛出的异常？
 * @author wangzh
 */
public class BaseController {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exceptionHandler (Exception ex) {
        if (ex instanceof CommonException) {
            return new Result(0, ex.getMessage());
        }
        return new Result(999, ex.getMessage());
    }
}
