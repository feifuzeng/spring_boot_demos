//package com.ohaotian.feifz.mq;
//
//import com.ohaotian.feifz.mq.rabbitmq.HelloSenderService;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//
///**
// * @author feifz
// * @version 1.0.0
// * @Description TOOD
// * @Date 2019/1/8 10:32
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class RabbitMqHelloTest {
//
//    @Resource
//    private HelloSenderService helloSenderService;
//
//    @Test
//    public void hello() throws Exception {
//        helloSenderService.send("");
//    }
//
//    @Test
//    public void oneToMany() throws Exception {
//        for (int i=0;i<100;i++){
//            helloSenderService.send(i+"xiaoxi");
//        }
//    }
//
//}
