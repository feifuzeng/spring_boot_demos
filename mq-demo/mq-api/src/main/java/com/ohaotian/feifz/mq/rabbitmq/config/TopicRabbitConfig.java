package com.ohaotian.feifz.mq.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author feifz
 * @version 1.0.0
 * @Description rabbitmq-topic规则配置
 * @Date 2019/1/8 17:29
 */
@Configuration
public class TopicRabbitConfig {

    public final static String TOPIC_MESSAGE = "topic.message";
    public final static String TOPIC_MESSAGES = "topic.messages";

    @Bean
    public Queue queueMessage() {
        return new Queue(TopicRabbitConfig.TOPIC_MESSAGE);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(TopicRabbitConfig.TOPIC_MESSAGES);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
