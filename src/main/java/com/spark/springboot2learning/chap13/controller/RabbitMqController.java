package com.spark.springboot2learning.chap13.controller;

import com.spark.springboot2learning.chap13.pojo.User;
import com.spark.springboot2learning.chap13.service.RabbitMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author initiald0824
 * @date 2019/8/28 20:54
 */
@RestController
@RequestMapping("/rabbitmq")
public class RabbitMqController {

    @Autowired
    private RabbitMqService rabbitMqService = null;

    /**
     * 字符串消息
     * @param message
     * @return
     */
    @GetMapping("/msg")
    public Map<String, Object> msg(String message) {
        rabbitMqService.sendMsg(message);
        return resultMap("message", message);
    }

    /**
     * 用户消息
     * @param id
     * @param userName
     * @param note
     * @return
     */
    @GetMapping("/user")
    public Map<String, Object> user(Long id, String userName, String note) {
        User user = new User(id, userName, note);
        rabbitMqService.sendUser(user);
        return resultMap("user", user);
    }


    private Map<String, Object> resultMap(String key, Object obj) {
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put(key, obj);
        return result;
    }
}
