package com.ohaotian.feifz.mq.kafka;

/**
 * @Author: feifz
 * @Date: 2019-03-11 15:26
 * @Version: 1.0
 * @Description: kafka client
 */
public class KafkaClient {

    public static void main(String[] args) {
        KafkaConsumerService pro = new KafkaConsumerService(KafkaConfig.KafkaProperties.TOPIC);
        pro.start();
    }

}