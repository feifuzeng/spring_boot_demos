package com.github.feifuzeng.mq.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.github.feifuzeng.mq.activemq.bo.User;
import com.github.feifuzeng.mq.result.BaseResult;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import lombok.extern.log4j.Log4j2;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 发送rabbitmq消息-controller
 * @Date 2019/1/8 10:43
 */
@Controller
@RequestMapping("/rabbitmq")
@Log4j2
public class RabbitmqProducerController {

    @Resource
    private RabbitmqConsumerService rabbitmqConsumerService;

    /**
     * 单条-发送rabbitmq消息
     * @return
     */
    @RequestMapping("/sendSingleRabbitmqMsg")
    @ResponseBody
    public BaseResult sendSingleRabbitmqMsg(@RequestBody User user){
        BaseResult result = new BaseResult();
        log.info("==========>>>>>发送到Rabbitmq消息：{}",JSON.toJSONString(user));
        rabbitmqConsumerService.send(user);
        return result;
    }

    /**
     * 批量-发送rabbitmq消息
     * @return
     */
    @RequestMapping("/sendMultiRabbitmqMsg")
    @ResponseBody
    public BaseResult sendMultiRabbitmqMsg(@RequestBody User user){
        BaseResult result = new BaseResult();
        log.info("==========>>>>>发送到Rabbitmq消息：{}",JSON.toJSONString(user));
        for(int i=0;i<100;i++){
            rabbitmqConsumerService.send(user);
        }
        return result;
    }

    /**
     * 发送rabbitmq消息-topic消息
     * @return
     */
    @RequestMapping("/sendTopicMsg")
    @ResponseBody
    public BaseResult sendTopicMsg(@RequestBody User user){
        BaseResult result = new BaseResult();
        log.info("==========>>>>>发送到Rabbitmq消息：{}",JSON.toJSONString(user));
        rabbitmqConsumerService.sendTopicMsg(JSON.toJSONString(user));
        return result;
    }
}
