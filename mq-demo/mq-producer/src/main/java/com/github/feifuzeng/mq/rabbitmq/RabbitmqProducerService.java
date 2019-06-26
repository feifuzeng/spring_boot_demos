package com.github.feifuzeng.mq.rabbitmq;

import com.github.feifuzeng.mq.activemq.bo.User;
import com.github.feifuzeng.mq.rabbitmq.config.RabbitmqConfig;
import com.github.feifuzeng.mq.rabbitmq.config.TopicRabbitConfig;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 发送者
 * @Date 2019/1/8 10:04
 */
@Service
public class RabbitmqProducerService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 发送rabbitmq消息-queue
     * @param user
     */
    @RabbitListener(queues = RabbitmqConfig.QUEUE,containerFactory="rabbitListenerContainerFactory")
    public void send(User user) {
        this.rabbitTemplate.convertAndSend(RabbitmqConfig.QUEUE, user);
    }

    /**
     * 发送rabbitmq消息-topic
     * @param msg
     * @desc 发送sendTopicMsg会匹配到topic.#和topic.message 两个Receiver都可以收到消息
     */
    @RabbitListener(queues = TopicRabbitConfig.TOPIC_MESSAGE,containerFactory="rabbitListenerContainerFactory")
    public void sendTopicMsg(String msg) {
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", msg);
    }

    /**
     * 发送rabbitmq消息-topic
     * @param msg
     * @desc 发送sendTopicMsg1只有topic.#可以匹配所有只有Receiver2监听到消息
     */
    @RabbitListener(queues = TopicRabbitConfig.TOPIC_MESSAGES,containerFactory="rabbitListenerContainerFactory")
    public void sendTopicMsg1(String msg) {
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", msg);
    }
}
