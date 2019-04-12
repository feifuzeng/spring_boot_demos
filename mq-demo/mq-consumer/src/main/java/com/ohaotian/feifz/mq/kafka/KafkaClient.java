package com.ohaotian.feifz.mq.kafka;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: feifz
 * @Date: 2019-03-11 15:26
 * @Version: 1.0
 * @Description: kafka client
 */
public class KafkaClient {

    public static void main(String[] args) {
//        KafkaConsumerService pro = new KafkaConsumerService(KafkaConfig.KafkaProperties.TOPIC);
//        pro.start();

        KafkaConsumerNewService kafkaConsumerNewService = new KafkaConsumerNewService();
        List<String> topic = new ArrayList<>();
        topic.add("test.test");
        kafkaConsumerNewService.receive(topic);
    }

}