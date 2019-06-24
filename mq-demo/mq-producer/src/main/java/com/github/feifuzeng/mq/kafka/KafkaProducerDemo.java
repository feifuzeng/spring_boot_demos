package com.github.feifuzeng.mq.kafka;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

/**
 * @Author: feifz
 * @Date: 2019-05-31 14:58
 * @Version: 1.0
 * @Description: kafka 发送消息示例
 */
@Log4j2
public class KafkaProducerDemo {

    public static void main(String[] args) {
        String brokeList = "39.96.117.232:9092";
        String topic = "testTopic";
        String key = "testKey";
        String message = "this is a test kafka messageo!";
        Producer<String, String> producer = initProducer(brokeList);
        producer.send(new ProducerRecord<>(topic, key, JSONObject.toJSONString(message)), new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if (e == null) {
                    System.out.println("## 发送消息成功->"+JSONObject.toJSONString(message));
                } else {
                    System.out.println("## 发送消息失败->{}"+e.getMessage());
                }
            }
        });
        producer.close();
    }

    /**
     * 初始化producer
     * @param brokeList
     * @return
     */
    private static Producer<String, String> initProducer(String brokeList) {
        Properties props = new Properties();
        props.put("bootstrap.servers", brokeList);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432L);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<>(props);
        return producer;
    }

}
