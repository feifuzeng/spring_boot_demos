package com.ohaotian.feifz.style;

import com.ohaotian.feifz.style.study.activemq.JMSConsumer;
import com.ohaotian.feifz.style.study.activemq.JMSProducer;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StyleBootApplicationTests {


    @Test
    public void contextLoads() {
    }

    @Autowired
    private JMSProducer jmsProducer;

    @Autowired
    private Topic topic;
    @Autowired
    private Queue queue;

    @Test
    public void testJms() {
        Destination destination = new ActiveMQQueue("springboot.queue.test");
        for (int i=0;i<10;i++) {
            jmsProducer.sendMessage(destination,"hello,world!" + i);
        }
    }

    @Test
    public void testJms2() {
        for (int i=0;i<10;i++) {
            jmsProducer.sendMessage(queue,"queue,world!" + i);
            jmsProducer.sendMessage(topic, "topic,world!" + i);
        }
    }

}

