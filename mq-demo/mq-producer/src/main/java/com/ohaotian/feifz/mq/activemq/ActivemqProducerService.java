package com.ohaotian.feifz.mq.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 消息生产者
 * @Date 2019/1/4 11:54
 */
@Service
public class ActivemqProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 发送消息，destination是发送到的队列，message是待发送的消息
      */
    public void sendMessage(Destination destination, final String message){
        jmsTemplate.convertAndSend(destination, message);
    }


}

