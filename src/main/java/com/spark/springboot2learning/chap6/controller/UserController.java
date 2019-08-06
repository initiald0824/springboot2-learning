package com.spark.springboot2learning.chap6.controller;

import com.spark.springboot2learning.chap6.pojo.User;
import com.spark.springboot2learning.chap6.service.UserBatchService;
import com.spark.springboot2learning.chap6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @Autowired
    private UserBatchService userBatchService = null;

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

    @RequestMapping("/insertUsers")
    public Map<String, Object> insertUsers(String userName1, String note1, String userName2, String note2) {
        User user1 = new User();
        user1.setUserName(userName1);
        user1.setNote(note1);
        User user2 = new User();
        user2.setUserName(userName2);
        user2.setNote(note2);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        int inserts = userBatchService.insertUsers(userList);
        Map<String, Object> result = new HashMap<>();
        result.put("success", inserts > 0);
        result.put("user", userList);
        return result;
    }
}
