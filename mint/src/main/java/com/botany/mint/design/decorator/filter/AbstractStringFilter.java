package com.botany.mint.design.decorator.filter;

public abstract class AbstractStringFilter implements StringFilter {
    private StringFilter stringFilter;

    public void setNextStringFilter(StringFilter stringFilter) {
        this.stringFilter = stringFilter;
    }

    public String filter(String source) {
        String target = doFilter(source);
        if (stringFilter == null) {
            return target;
        }
        return stringFilter.filter(target);
    }

    public abstract String doFilter(String source);
}
