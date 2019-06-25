package com.github.feifuzeng.designpattern.proxy;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 客户端
 * @createTime 2019年06月25日 15:13:00
 */
public class Client {
    public static void main(String[] args) {
        /** 创建委托类*/
        Subject mRealSubject=new RealSubject();
        /** 创建代理类*/
        ProxySubject mProxy = new ProxySubject(mRealSubject);
        /** 由代理类去做具体的操作*/
        mProxy.doSomething();
    }

}
