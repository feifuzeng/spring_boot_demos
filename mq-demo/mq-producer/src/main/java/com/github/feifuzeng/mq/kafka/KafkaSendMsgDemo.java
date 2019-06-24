package com.github.feifuzeng.mq.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Author: feifz
 * @Date: 2019-05-31 15:34
 * @Version: 1.0
 * @Description: kafka 发送消息三种方式发送消息示例代码
 * @Refer https://www.cnblogs.com/FG123/p/10091478.html
 */
public class KafkaSendMsgDemo {

    public static void main(String[] args) {

        /**
         三种方式虽然在时间上有所差别，但并不是说时间越快的越好，具体要看业务的应用场景：

         场景1：如果业务要求消息必须是按顺序发送的，那么可以使用同步的方式，并且只能在一个partation上或指定同一个key，结合参数设置retries的值让发送失败时重试，设置max_in_flight_requests_per_connection=1，可以控制生产者在收到服务器晌应之前只能发送1个消息，从而控制消息顺序发送；

         场景2：如果业务只关心消息的吞吐量，容许少量消息发送失败，也不关注消息的发送顺序，那么可以使用发送并忘记的方式，并配合参数acks=0，这样生产者不需要等待服务器的响应，以网络能支持的最大速度发送消息；

         场景3：如果业务需要知道消息发送是否成功，并且对消息的顺序不关心，那么可以用异步+回调的方式来发送消息，配合参数retries=0，并将发送失败的消息记录到日志文件中；
         * */

        wayThree();
    }

    /**
     * 发送并忘记(不关心消息是否正常到达，对返回结果不做任何判断处理)
     */
    public static void wayOne() {
        String brokeList = "127.0.0.1:9092";
        String topic = "testTopic";
        String key = "testKey";
        Producer<String, String> producer = initProducer(brokeList);
        long before = System.currentTimeMillis();
        System.out.println("发送前-->"+before);
        for(int i=1 ;i<10000;i++){
            producer.send(new ProducerRecord<>(topic, 0,key, String.valueOf(i)));
        }
        producer.flush();
        producer.close();
        long after = System.currentTimeMillis();
        System.out.println("发送后-->"+after);
        long temp = after-before;
        System.out.println("时间间隔-->"+temp);

    }

    /**
     * 同步发送-(通过get方法等待Kafka的响应，判断消息是否发送成功)
     */
    public static void wayTwo() {
        String brokeList = "39.96.117.232:9092";
        String topic = "testTopic";
        String key = "testKey";
        Producer<String, String> producer = initProducer(brokeList);
        long before = System.currentTimeMillis();
        System.out.println("发送前-->"+before);
        for(int i=1 ;i<10000;i++){
            Future<RecordMetadata> recordMetadataFuture =  producer.send(new ProducerRecord<>(topic,key, String.valueOf(i)));
            try {
                RecordMetadata record = recordMetadataFuture.get(10, TimeUnit.MICROSECONDS);
                System.out.println(record.toString());
            }catch (Exception e){
                System.out.println(e);
            }

        }
        long after = System.currentTimeMillis();
        System.out.println("发送后-->"+after);
        long temp = after-before;
        System.out.println("时间间隔-->"+temp);

    }

    /**
     * 异步发送+回调函数(消息以异步的方式发送，通过回调函数返回消息发送成功/失败)
     */
    public static void wayThree() {
        String brokeList = "39.96.117.232:9092";
        String topic = "testTopic";
        String key = "testKey";
        Producer<String, String> producer = initProducer(brokeList);
        long before = System.currentTimeMillis();
        System.out.println("发送前-->"+before);
        for(int i=1 ;i<10000;i++){
            producer.send(new ProducerRecord<>(topic, key, String.valueOf(i)), new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if(e==null){
                        System.out.println("## 发送消息成功->");
                    }else {
                        System.out.println("## 发送消息失败->{}"+e.getMessage());
                    }
                }
            });
        }
        long after = System.currentTimeMillis();
        System.out.println("发送后-->"+after);
        long temp = after-before;
        System.out.println("时间间隔-->"+temp);
    }

    /**
     * 初始化producer
     * @param brokeList
     * @return
     */
    private static Producer<String, String> initProducer(String brokeList) {
        Properties props = new Properties();
        props.put("bootstrap.servers", brokeList);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("retries", 0);
        Producer<String, String> producer = new KafkaProducer<>(props);
        return producer;
    }

}
