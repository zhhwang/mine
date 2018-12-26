package com.botany.mint.design.builder;

/**
 * @author wangzh
 */
public class ConcreteBuildTwo extends Builder {
    Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("X");
    }

    @Override
    public void buildPartB() {
        product.add("Y");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
