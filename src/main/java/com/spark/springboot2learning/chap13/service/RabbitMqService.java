package com.spark.springboot2learning.chap13.service;

import com.spark.springboot2learning.chap13.pojo.User;

/**
 * @author initiald0824
 * @date 2019/8/28 20:26
 */
public interface RabbitMqService {

    /**
     * 发送字符消息
     * @param msg
     */
    public void sendMsg(String msg);

    /**
     * 发送用户消息
     * @param user
     */
    public void sendUser(User user);
}
