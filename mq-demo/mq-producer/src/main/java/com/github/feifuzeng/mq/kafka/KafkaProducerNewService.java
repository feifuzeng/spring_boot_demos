package com.github.feifuzeng.mq.kafka;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

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
        props.put("bootstrap.servers", KafkaConfig.KafkaProperties.BROKER_LIST);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        String message = "123456";
        try{
            producer.send(new ProducerRecord<>(topic, "key", JSONObject.toJSONString(message)), new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if(e==null){
                        System.out.println("## 发送消息成功->{}"+JSONObject.toJSONString(message));
                    }else {
                        System.out.println("## 发送消息失败->{}"+e.getMessage());
                    }
                }
            });
//            producer.send(new ProducerRecord<>(topic,  "1qaz2wsxcde3"));
            System.out.println("successful!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            producer.close();
        }


    }

}
