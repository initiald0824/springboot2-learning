package com.spark.springboot2learning.chap7.listener;


import org.springframework.data.redis.connection.Message;
import org.springframework.stereotype.Component;

/**
 * @author initiald0824
 * @date 2019/8/8 12:00
 */
@Component
public class MessageListener implements org.springframework.data.redis.connection.MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String body = new String(message.getBody());
        String topic = new String(pattern);
        System.out.println(body);
        System.out.println(topic);
    }
}
