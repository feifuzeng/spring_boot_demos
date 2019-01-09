package com.ohaotian.feifz.style.study.activemqspring;

/**
 * @author feifz
 * @version 1.0.0
 * @Description Listerner02 订阅者02的监听器
 * @Date 2019/1/4 10:19
 */

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class Listerner02 implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("订阅者02接收到消息：" + ((TextMessage) message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
