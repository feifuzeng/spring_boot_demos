package com.github.feifuzeng.designpattern.chain;

import com.github.feifuzeng.designpattern.chain.impl.ConcreteHandler;

/**
 * @Author: feifz
 * @Date: 2019-03-16 23:20
 * @Version: 1.0
 * @Description: TODO
 */
public class Client {

    public static void main(String[] args) {
        //组装责任链
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        handler1.setSuccessor(handler2);
        //提交请求
        handler1.handleRequest();
    }
}

