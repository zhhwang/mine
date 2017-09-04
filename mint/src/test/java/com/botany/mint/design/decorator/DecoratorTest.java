package com.botany.mint.design.decorator;

import com.botany.mint.design.decorator.factory.StringFilterFactory;
import com.botany.mint.design.decorator.filter.StringFilter;
import org.junit.Test;

public class DecoratorTest {

    @Test
    public void decoratorTest() {
        String chain = "html,js,dirty";
        StringFilter stringFilter = StringFilterFactory.getInstance().getStringFilterChain(chain);
        String source = "<b>aaaa</b>";
        stringFilter.filter(source);
    }
}
