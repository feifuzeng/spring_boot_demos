//package com.ohaotian.feifz.mq.kafka;
//
///**
// * @Author: feifz
// * @Date: 2019-03-11 15:23
// * @Version: 1.0
// * @Description: kafka produce service based on kafka version 0.8.2.1
// */
//
//import kafka.javaapi.producer.Producer;
//import kafka.producer.KeyedMessage;
//import kafka.producer.ProducerConfig;
//
//import java.util.Properties;
//
//public class KafkaProducerService extends Thread {
//
//    private Producer<Integer, String> producer;
//    private String topic;
//    private Properties props = new Properties();
//    private final int SLEEP = 1000 * 3;
//
//    public KafkaProducerService(String topic) {
//        props.put("serializer.class", "kafka.serializer.StringEncoder");
//        props.put("metadata.broker.list", "127.0.0.1:9092");
//        producer = new Producer<Integer, String>(new ProducerConfig(props));
//        this.topic = topic;
//    }
//
//    @Override
//    public void run() {
//        int offsetNo = 1;
//        while (true) {
//            try {
//            String msg = new String("Message_" + offsetNo);
//            System.out.println("Send->[" + msg + "]");
//            producer.send(new KeyedMessage<Integer, String>(topic, msg));
//            offsetNo++;
//                sleep(SLEEP);
//            } catch (Exception ex) {
//                System.out.println(ex);
//                ex.printStackTrace();
//            }
//        }
//    }
//
//}