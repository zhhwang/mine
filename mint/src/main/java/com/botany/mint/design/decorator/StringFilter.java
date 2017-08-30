package com.botany.mint.design.decorator;

/**
 * 由于Decorator是嵌套结构(注：这里只用了前(before)装饰，所以看起来有点像链结构，如有必要，也可以加上后(after)装饰)，
 * 它的调用关系需要组装，所以应该用建造者(Builder)模式或简单工厂模式。，工厂的获取用单例(Singleton)模式返回
 */
public interface StringFilter {
    void setNextStringFilter(StringFilter stringFilter);

    String filter(String source);
}
