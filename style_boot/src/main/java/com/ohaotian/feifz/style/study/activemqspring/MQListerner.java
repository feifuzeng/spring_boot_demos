package com.ohaotian.feifz.style.study.activemqspring;

/**
 * @author feifz
 * @version 1.0.0
 * @Description MQListerner 生产者监听器
 * @Date 2019/1/4 10:16
 */
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
public class MQListerner implements MessageListener{

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println(((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
