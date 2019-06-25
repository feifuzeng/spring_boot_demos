package com.github.feifuzeng.designpattern.decorator;

import com.github.feifuzeng.designpattern.decorator.impl.Decorator;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 装饰器模式示例-装饰器子类-镂空
 * @createTime 2019年04月16日 14:52:00
 */
public class Hollow extends Decorator {

    public Hollow(Clothes _clothes) {
        super(_clothes);
    }
    public void hollow() {
        System.out.println("关键位置镂空");
    }
    @Override
    public void makeClothes() {
        super.makeClothes();
        this.hollow();
    }
}