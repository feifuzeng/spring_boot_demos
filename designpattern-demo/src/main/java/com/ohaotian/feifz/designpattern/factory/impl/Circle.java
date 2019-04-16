package com.ohaotian.feifz.designpattern.factory.impl;

import com.ohaotian.feifz.designpattern.factory.Shape;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 装饰器模式示例-接口实现-圆
 * @createTime 2019年04月16日 16:20:00
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}