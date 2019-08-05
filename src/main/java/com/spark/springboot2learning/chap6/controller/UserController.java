package com.spark.springboot2learning.chap6.controller;

import com.spark.springboot2learning.chap6.pojo.User;
import com.spark.springboot2learning.chap6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author initiald0824
 * @date 2019/8/6 0:19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService = null;

    @RequestMapping("/getUser")
    public User getUser(Long id) {
        return userService.getUser(id);
    }

    @RequestMapping("/insertUser")
    public Map<String, Object> insertUser(String userName, String note) {
        User user = new User();
        user.setUserName(userName);
        user.setNote(note);

        int update = userService.insertUser(user);
        Map<String, Object> result = new HashMap<>();
        result.put("success", update == 1);
        result.put("user", user);
        return result;
    }
}
