package com.botany.mint.design.strategy;

/**
 * Created by Administrator on 2017/10/17 0017.
 */
public class ReduceStrategy implements IStrategy{

    private final double reachPrice;

    private final double reducePrice;

    public ReduceStrategy() {
        this.reachPrice = 1000;
        this.reducePrice = 200;
    }

    @Override
    public double realPrice(double consumePrice) {
        if (consumePrice > this.reachPrice) {
            return consumePrice - this.reducePrice;
        } else {
            return consumePrice;
        }
    }
}
