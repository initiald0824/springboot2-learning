package com.spark.springboot2learning.chap4.aspect.controller;

import com.spark.springboot2learning.chap3.pojo.User;
import com.spark.springboot2learning.chap4.aspect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author initiald0824
 * @date 2019/8/3 16:40
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/print")
    public User printUser(Long id, String userName, String note) {
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setNote(note);
        userService.printUser(user);
        return user;
    }
}
