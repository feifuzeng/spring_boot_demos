package com.github.feifuzeng.designpattern.factory.impl;

import com.github.feifuzeng.designpattern.factory.Shape;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 装饰器模式示例-接口实现-正方形
 * @createTime 2019年04月16日 16:19:00
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}