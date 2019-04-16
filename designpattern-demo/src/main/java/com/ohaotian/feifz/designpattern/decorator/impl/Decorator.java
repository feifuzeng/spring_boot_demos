package com.ohaotian.feifz.designpattern.decorator.impl;

import com.ohaotian.feifz.designpattern.decorator.Clothes;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 装饰器模式示例-装饰器定义
 * @createTime 2019年04月16日 14:50:00
 */
public class Decorator implements Clothes {

    private Clothes clothes;
    public Decorator(Clothes _clothes) {
        this.clothes = _clothes;
    }
    @Override
    public void makeClothes() {
        clothes.makeClothes();
    }
}
