package com.ohaotian.feifz.style.study.activemqspring;

/**
 * @author feifz
 * @version 1.0.0
 * @Description TOOD
 * @Date 2019/1/4 10:18
 */
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * <p>
 * Listerner01 订阅者01的监听器
 * <p>
 */
public class Listerner01 implements MessageListener{

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("订阅者01接收到消息：" + ((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
