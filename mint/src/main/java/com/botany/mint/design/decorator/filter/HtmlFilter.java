package com.botany.mint.design.decorator.filter;

import com.botany.mint.design.decorator.AbstractStringFilter;
import org.springframework.util.StringUtils;

public class HtmlFilter extends AbstractStringFilter {
    public String doFilter(String source) {
        source = StringUtils.replace(source, "<", "& lt;");
        source = StringUtils.replace(source, ">", "& gt;");
        source = StringUtils.replace(source, "&", "& amp;");
        source = StringUtils.replace(source, " ", "& nbsp;");
        source = StringUtils.replace(source, "\"", "& #0034;");
        source = StringUtils.replace(source, "\'", "& #0039;");
        return source;
    }
}
