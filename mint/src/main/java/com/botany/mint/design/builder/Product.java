package com.botany.mint.design.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzh
 */
public class Product {
    List<String> parts = new ArrayList<>();

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        for (String part: parts) {
            System.out.println(part);
        }
    }
}
