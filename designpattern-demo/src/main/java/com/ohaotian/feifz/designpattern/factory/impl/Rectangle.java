package com.ohaotian.feifz.designpattern.factory.impl;

import com.ohaotian.feifz.designpattern.factory.Shape;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 装饰器模式示例-接口实现-矩形
 * @createTime 2019年04月16日 16:19:00
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}