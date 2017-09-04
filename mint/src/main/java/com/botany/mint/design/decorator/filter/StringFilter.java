package com.botany.mint.design.decorator.filter;

/**
 * 它的调用关系需要组装，所以应该用建造者(Builder)模式或简单工厂模式。，工厂的获取用单例(Singleton)模式返回
 */
public interface StringFilter {
    void setNextStringFilter(StringFilter stringFilter);

    String filter(String source);
}
