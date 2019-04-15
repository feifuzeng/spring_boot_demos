package com.ohaotian.feifz.designpattern.strategy;

import com.ohaotian.feifz.designpattern.strategy.impl.OperationAdd;
import com.ohaotian.feifz.designpattern.strategy.impl.OperationMultiply;
import com.ohaotian.feifz.designpattern.strategy.impl.OperationSubstract;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 策略模式-示例
 * @createTime 2019年04月15日 17:28:00
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}