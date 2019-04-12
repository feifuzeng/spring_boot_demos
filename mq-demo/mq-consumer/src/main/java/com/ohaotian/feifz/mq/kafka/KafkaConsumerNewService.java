package com.ohaotian.feifz.mq.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.List;
import java.util.Properties;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 基于 api 2.2.0 kafka 消息消费者服务层
 * @createTime 2019年04月12日 15:28:00
 */
public class KafkaConsumerNewService {

    public void receive(List<String> topic){

        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(topic);
        while (true) {
            try {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }


        }
    }
}
