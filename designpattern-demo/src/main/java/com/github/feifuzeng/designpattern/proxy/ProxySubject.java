package com.github.feifuzeng.designpattern.proxy;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 代理主题
 * @createTime 2019年06月25日 15:12:00
 */
public class ProxySubject implements Subject {

    private Subject mSubject;
    /**  代理类持有委托类的引用*/
    public ProxySubject(Subject realSubject) {
        mSubject = realSubject;
    }

    @Override
    public void doSomething() {
        mSubject.doSomething();
    }
}
