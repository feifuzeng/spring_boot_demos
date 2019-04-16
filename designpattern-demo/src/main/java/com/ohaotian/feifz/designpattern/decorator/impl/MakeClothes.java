package com.ohaotian.feifz.designpattern.decorator.impl;

import com.ohaotian.feifz.designpattern.decorator.Clothes;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 装饰器模式示例-接口实现类
 * @createTime 2019年04月16日 14:49:00
 */
public class MakeClothes implements Clothes {

    @Override
    public void makeClothes() {
        System.out.println("制作一件衣服");
    }

}

