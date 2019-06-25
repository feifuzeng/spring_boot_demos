package com.github.feifuzeng.designpattern.proxy;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 真正实现的主题类
 * @createTime 2019年06月25日 15:11:00
 */
public class RealSubject implements Subject{
    @Override
    public void doSomething() {
        System.out.println("This is real doSomeThing");
    }
}
