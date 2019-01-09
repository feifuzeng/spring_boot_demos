package com.ohaotian.feifz.style.study.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author feifz
 * @version 1.0.0
 * @Description JMS的配置类
 * @Date 2019/1/4 14:39
 */
@Configuration
public class JmsConfig {
    public final static String TOPIC = "springboot.topic.test";
    public final static String QUEUE = "springboot.queue.test";
    @Bean
    public Queue queue() {
        return new ActiveMQQueue(QUEUE);
    }

    @Bean
    public Topic topic() {
        return new ActiveMQTopic(TOPIC);
    }

    /**
     * topic模式的ListenerContainer
      */
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }
    /**
     * queue模式的ListenerContainer
      */
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }
}
