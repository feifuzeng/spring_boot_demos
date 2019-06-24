package com.github.feifuzeng.mq.kafka;

/**
 * @Author: feifz
 * @Date: 2019-03-11 15:26
 * @Version: 1.0
 * @Description: kafka client
 */
public class KafkaProducerClient {

    public static void main(String[] args) {
//        KafkaProducerService pro = new KafkaProducerService(KafkaConfig.KafkaProperties.TOPIC);
//        pro.start();


        KafkaProducerNewService pro = new KafkaProducerNewService();
        pro.send(KafkaConfig.KafkaProperties.TOPIC);

    }

}