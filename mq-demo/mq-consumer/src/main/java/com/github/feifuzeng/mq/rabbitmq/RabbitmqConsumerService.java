package com.github.feifuzeng.mq.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.github.feifuzeng.mq.activemq.bo.User;
import com.github.feifuzeng.mq.rabbitmq.config.RabbitmqConfig;
import com.github.feifuzeng.mq.rabbitmq.config.TopicRabbitConfig;
import com.github.feifuzeng.mq.user.UserService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import lombok.extern.log4j.Log4j2;

/**
 * @author feifz
 * @version 1.0.0
 * @Description TOOD
 * @Date 2019/1/8 10:05
 */
@Component
@Log4j2
public class RabbitmqConsumerService {

    @Resource
    private UserService userService;

//    @RabbitHandler
    @RabbitListener(queues = RabbitmqConfig.QUEUE,containerFactory="rabbitListenerContainerFactory")
    public void process(@Payload User user) {
        log.info("<<<<<<<<=============接收到Rabbitmq消息：{}",JSON.toJSONString(user));
        userService.addUser(user);
    }

    @RabbitListener(queues = TopicRabbitConfig.TOPIC_MESSAGE,containerFactory="rabbitListenerContainerFactory")
    public void processTopicMsg(String msg) {
        log.info("<<<<<<<<=============接收到Rabbitmq消息：{}",msg);
    }


    @RabbitListener(queues = TopicRabbitConfig.TOPIC_MESSAGES,containerFactory="rabbitListenerContainerFactory")
    public void processTopicMsg1(String msg) {
        log.info("<<<<<<<<=============接收到Rabbitmq消息：{}",msg);
    }

}
