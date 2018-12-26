package com.botany.mint.design.builder;

/**
 * @author wangzh
 */
public class ConcreteBuildOne extends Builder {
    Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("I");
    }

    @Override
    public void buildPartB() {
        product.add("J");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
