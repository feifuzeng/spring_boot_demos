package com.github.feifuzeng.designpattern.decorator;

import com.github.feifuzeng.designpattern.decorator.impl.MakeClothes;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 装饰器模式示例-测试类
 * @createTime 2019年04月16日 14:53:00
 */
public class DecoratorDemo {

    public static void main(String[] args) {
        Clothes clothes = new MakeClothes();
        clothes = new Embroidery(clothes);
        clothes = new Hollow(clothes);
        clothes.makeClothes();
        System.out.println("衣服做好了");
    }
}
