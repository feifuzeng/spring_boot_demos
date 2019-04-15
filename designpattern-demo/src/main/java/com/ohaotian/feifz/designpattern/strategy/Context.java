package com.ohaotian.feifz.designpattern.strategy;

/**
 * @author feifz
 * @version 1.0.0
 * @Description Context 是一个使用了某种策略的类
 * @createTime 2019年04月15日 17:27:00
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
