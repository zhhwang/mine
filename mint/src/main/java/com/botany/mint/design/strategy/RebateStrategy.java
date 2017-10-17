package com.botany.mint.design.strategy;

/**
 * Created by Administrator on 2017/10/17 0017.
 */
public class RebateStrategy implements IStrategy{

    private final double rate;

    public RebateStrategy(double rate) {
        this.rate = 0.8;
    }

    @Override
    public double realPrice(double consumePrice) {
        return consumePrice * this.rate;
    }
}
