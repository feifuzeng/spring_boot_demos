package com.ohaotian.feifz.mq.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 基于 api 2.2.0 kafka 消息发送者服务层
 * @createTime 2019年04月12日 14:51:00
 */
public class KafkaProducerNewService {


    public void send(String topic){
        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        try{
            producer.send(new ProducerRecord<>(topic,  "1qaz2wsxcde3"));
            System.out.println("successful!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            producer.close();
        }


    }

}
