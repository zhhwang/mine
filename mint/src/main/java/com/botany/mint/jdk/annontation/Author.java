package com.botany.mint.jdk.annontation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Author {

    String name() default "wangzh";
}
