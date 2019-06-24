
# 简单消息

> 参考：https://rocketmq.apache.org/docs/simple-example/

## 可靠同步发送
  [SyncProducer.java](mq-producer/src/main/java/com/github/feifuzeng/mq/rocketmq/simple/SyncProducer.java)
## 可靠异步发送
  [AsyncProducer.java](mq-producer/src/main/java/com/github/feifuzeng/mq/rocketmq/simple/AsyncProducer.java)
## 单向（Oneway）发送
  [OnewayProducer.java](mq-producer/src/main/java/com/github/feifuzeng/mq/rocketmq/simple/OnewayProducer.java)
## 订阅
  [Consumer.java](mq-consumer/src/main/java/com/github/feifuzeng/mq/rocketmq/simple/Consumer.java)
  
# 顺序消息发送

> 参考：https://rocketmq.apache.org/docs/order-example/

## 发送
  [OrderedProducer.java](mq-producer/src/main/java/com/github/feifuzeng/mq/rocketmq/order/OrderedProducer.java)
## 订阅
  [AsyncProducer.java](mq-consumer/src/main/java/com/github/feifuzeng/mq/rocketmq/order/OrderedConsumer.java)
