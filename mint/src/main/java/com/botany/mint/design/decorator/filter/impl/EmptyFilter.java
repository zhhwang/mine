package com.botany.mint.design.decorator.filter.impl;

import com.botany.mint.design.decorator.filter.AbstractStringFilter;

public class EmptyFilter extends AbstractStringFilter {
    public String doFilter(String source) {
        return source;
    }
}
