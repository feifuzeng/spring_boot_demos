package com.ohaotian.feifz.designpattern.strategy.impl;

import com.ohaotian.feifz.designpattern.strategy.Strategy;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 策略接口实现-减法
 * @createTime 2019年04月15日 17:26:00
 */
public class OperationSubstract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
