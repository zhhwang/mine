package com.botany.mint.design.strategy;

/**
 * Created by Administrator on 2017/10/17 0017.
 */
public class PromotionalStrategy implements IStrategy {
    private final double reachPrice;

    private final double rate;

    public PromotionalStrategy() {
        this.reachPrice = 200;
        this.rate = 0.8;
    }

    @Override
    public double realPrice(double consumePrice) {
        if (consumePrice > this.reachPrice){
            return this.reachPrice + (consumePrice - this.reachPrice) * this.rate;
        } else {
            return consumePrice;
        }
    }
}
