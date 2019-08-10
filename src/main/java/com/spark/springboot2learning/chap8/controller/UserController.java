package com.spark.springboot2learning.chap8.controller;

import com.spark.springboot2learning.chap8.pojo.User;
import com.spark.springboot2learning.chap8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author initiald0824
 * @date 2019/8/10 1:57
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService = null;


    @RequestMapping("/save")
    public User saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @RequestMapping("/get")
    public User getUser(Long id) {
        User user = userService.getUser(id);
        return user;
    }

    @RequestMapping("/find")
    public List<User> addUser(String userName, String note, Integer skip, Integer limit) {
        List<User> userList = userService.findUser(userName, note, skip, limit);
        return userList;
    }

}
