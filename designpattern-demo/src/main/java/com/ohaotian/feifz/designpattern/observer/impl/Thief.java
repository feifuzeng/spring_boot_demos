package com.ohaotian.feifz.designpattern.observer.impl;

import com.ohaotian.feifz.designpattern.observer.Watcher;

/**
 * @Author: feifz
 * @Date: 2019-03-15 17:16
 * @Version: 1.0
 * @Description: 具体的观察者-强盗
 */
public class Thief implements Watcher
{
    @Override
    public void update()
    {
        System.out.println("运输车有行动，强盗准备动手");
    }
}