package com.botany.vanilla.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wangzh
 */
@Controller
@RequestMapping("/api")
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public void sayHello(@RequestParam String name) {
        System.out.println("hello, " + name);
    }
}
