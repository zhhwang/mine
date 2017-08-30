package com.botany.mint.design.decorator;

public class Main {

    public static void main(String[] argd) {
        String chain = "html,js,dirty";
        StringFilter stringFilter = StringFilterFactory.getInstance().getStringFilterChain(chain);
        String source = "<b>aaaa</b>";
        String result = stringFilter.filter(source);
    }
}
