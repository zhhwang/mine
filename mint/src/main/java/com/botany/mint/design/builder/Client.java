package com.botany.mint.design.builder;

/**
 * @author wangzh
 */
public class Client {
    public static void main(String[] args) {
        Director director = new Director();

        ConcreteBuildOne one = new ConcreteBuildOne();
        director.direct(one);
        Product p1 = one.getResult();
        p1.show();

        ConcreteBuildTwo two = new ConcreteBuildTwo();
        director.direct(two);
        Product p2 = two.getResult();
        p2.show();
    }
}
