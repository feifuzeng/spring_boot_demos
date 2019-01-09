//package com.ohaotian.feifz.mq.activemq;
//
//import com.alibaba.fastjson.JSON;
//import com.ohaotian.feifz.mq.activemq.bo.User;
//import com.ohaotian.feifz.mq.activemq.config.ActivemqConfig;
//import com.ohaotian.feifz.mq.user.UserService;
//
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
//import lombok.extern.log4j.Log4j2;
//
///**
// * @author feifz
// * @version 1.0.0
// * @Description 消息消费者
// * @Date 2019/1/4 11:55
// */
//@Component
//@Log4j2
//public class ActivemqConsumerService {
//
//    @Resource
//    private UserService userService;
//
//    @JmsListener(destination = ActivemqConfig.TOPIC,containerFactory = "jmsListenerContainerTopic")
//    public void onTopicMessage(String msg) {
//        log.info("<<<<<<<<=============接收到topic消息：{}",msg);
//        User user = JSON.parseObject(msg,User.class);
//        userService.addUser(user);
//    }
//
//    @JmsListener(destination = ActivemqConfig.QUEUE,containerFactory = "jmsListenerContainerQueue")
//    public void onQueueMessage(String msg) {
//        log.info("<<<<<<<<=============接收到queue消息：{}",msg);
//        User user = JSON.parseObject(msg,User.class);
//        userService.addUser(user);
//    }
//}
