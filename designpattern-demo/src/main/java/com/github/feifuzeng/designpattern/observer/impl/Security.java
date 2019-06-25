package com.github.feifuzeng.designpattern.observer.impl;

import com.github.feifuzeng.designpattern.observer.Watcher;

/**
 * @Author: feifz
 * @Date: 2019-03-15 17:15
 * @Version: 1.0
 * @Description: 具体的观察者-保安
 */
public class Security implements Watcher
{
    @Override
    public void update()
    {
        System.out.println("运输车有行动，保安贴身保护");
    }
}