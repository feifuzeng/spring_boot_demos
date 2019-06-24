package com.github.feifuzeng.mq.activemq;

import com.alibaba.fastjson.JSON;
import com.github.feifuzeng.mq.activemq.bo.User;
import com.github.feifuzeng.mq.activemq.config.ActivemqConfig;
import com.github.feifuzeng.mq.result.BaseResult;
import lombok.extern.log4j.Log4j2;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 发送activemq消息 控制器
 * @Date 2019/1/4 16:26
 */
@Controller
@RequestMapping("/activemq")
@Log4j2
public class ActivemqProducerController {

    @Resource
    private ActivemqProducerService activemqProducerService;

    /**
     * 发送QUEUE mq消息
     */
    @RequestMapping("/sendActivemqQueueMsg")
    @ResponseBody
    public BaseResult sendQueue(@RequestBody User user) {
        BaseResult result = new BaseResult();
        log.info("发送queue消息=========>>>>>>>>>>"+user.toString());
        Destination destination = new ActiveMQQueue(ActivemqConfig.QUEUE);
        activemqProducerService.sendMessage(destination,JSON.toJSONString(user));
        return result;
    }

    /**
     * 发送TOPIC mq消息
     */
    @RequestMapping("/sendActivemqTopicMsg")
    @ResponseBody
    public BaseResult sendTopic(@RequestBody User user) {
        BaseResult result = new BaseResult();
        log.info("发送topic消息=========>>>>>>>>>>"+user.toString());
        Destination destination = new ActiveMQQueue(ActivemqConfig.TOPIC);
        activemqProducerService.sendMessage(destination,JSON.toJSONString(user));
        return result;
    }
}
