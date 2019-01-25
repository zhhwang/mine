package com.botany.mint.design.template;

/**
 * @author wangzh
 */
public class TemplatePatternDemo {

    public static void main() {
        Game cricket = new Cricket();
        cricket.play();

        Game football = new Football();
        football.play();
    }
}
