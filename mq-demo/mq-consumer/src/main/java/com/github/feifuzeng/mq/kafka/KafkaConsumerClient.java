package com.github.feifuzeng.mq.kafka;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: feifz
 * @Date: 2019-03-11 15:26
 * @Version: 1.0
 * @Description: kafka client
 */
public class KafkaConsumerClient {

    public static void main(String[] args) {
//        KafkaConsumerService pro = new KafkaConsumerService(KafkaConfig.KafkaProperties.TOPIC);
//        pro.start();

        KafkaConsumerNewService kafkaConsumerNewService = new KafkaConsumerNewService();
        List<String> topic = new ArrayList<>();
        topic.add(KafkaConfig.KafkaProperties.TOPIC);
        kafkaConsumerNewService.receive(topic);
    }

}