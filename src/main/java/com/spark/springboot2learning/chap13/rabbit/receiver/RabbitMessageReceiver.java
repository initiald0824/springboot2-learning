package com.spark.springboot2learning.chap13.rabbit.receiver;

import com.spark.springboot2learning.chap13.pojo.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author initiald0824
 * @date 2019/8/28 20:41
 */

@Component
public class RabbitMessageReceiver {

    @RabbitListener(queues = { "${rabbitmq.queue.msg}" })
    public void receiveMsg(String msg) {
        System.out.println("收到消息: 【" + msg + "】");
    }

    @RabbitListener(queues = { "${rabbitmq.queue.user}" })
    public void receiveUser(User user) {
        System.out.println("收到用户信息" + user + "】");
    }
}
