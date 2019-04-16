package com.ohaotian.feifz.designpattern.decorator;

import com.ohaotian.feifz.designpattern.decorator.impl.Decorator;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 装饰器模式示例-装饰器子类-绣花
 * @createTime 2019年04月16日 14:51:00
 */
public class Embroidery extends Decorator {

    public Embroidery(Clothes _clothes) {
        super(_clothes);
    }
    public void embroidery() {
        System.out.println("给衣服绣花");
    }
    @Override
    public void makeClothes() {
        super.makeClothes();
        this.embroidery();
    }
}
