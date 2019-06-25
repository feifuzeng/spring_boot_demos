package com.github.feifuzeng.designpattern.strategy.impl;

import com.github.feifuzeng.designpattern.strategy.Strategy;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 策略接口实现-加法
 * @createTime 2019年04月15日 17:24:00
 */
public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
