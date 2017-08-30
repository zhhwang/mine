package com.botany.mint.design.decorator.filter;

import com.botany.mint.design.decorator.AbstractStringFilter;

public class EmptyFilter extends AbstractStringFilter {
    public String doFilter(String source) {
        return source;
    }
}
