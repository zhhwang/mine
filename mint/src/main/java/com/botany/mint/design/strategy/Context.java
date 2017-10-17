package com.botany.mint.design.strategy;

/**
 * 整合
 */
public class Context {

    private final IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public double cul(double consumePrice) {
        return this.strategy.realPrice(consumePrice);
    }
}
