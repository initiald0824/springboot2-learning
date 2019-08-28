package com.spark.springboot2learning.chap13.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author initiald0824
 * @date 2019/8/28 20:19
 */
@Configuration
public class RabbitMqConfig {

    /**
     * 消息队列名称
     */
    @Value("${rabbitmq.queue.msg}")
    private String msgQueueName = null;

    /**
     * 用户队列名称
     */
    @Value("${rabbitmq.queue.user}")
    private String userQueueName = null;

    /**
     * 创建字符串消息队列，boolean值代表是否持久化消息
     * @return
     */
    @Bean
    public Queue createQueueMsg() {
        return new Queue(msgQueueName, true);
    }

    /**
     * 创建用户消息队列，boolean值代表是否持久化消息
     * @return
     */
    @Bean
    public Queue createQueueUser() {
        return new Queue(userQueueName, true);
    }
}
