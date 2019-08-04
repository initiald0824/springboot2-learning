package com.spark.springboot2learning.chap4.aspect.controller;

import com.spark.springboot2learning.chap3.pojo.UserChap4;
import com.spark.springboot2learning.chap4.aspect.service.UserService;
import com.spark.springboot2learning.chap4.aspect.validator.UserValidator;
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
    public UserChap4 printUser(Long id, String userName, String note) {
        UserChap4 userChap4 = new UserChap4();
        userChap4.setId(id);
        userChap4.setUserName(userName);
        userChap4.setNote(note);
        userService.printUser(userChap4);
        return userChap4;
    }

    @RequestMapping("/vp")
     public UserChap4 validateAndPrint(Long id, String userName, String note) {
        UserChap4 userChap4 = new UserChap4();
        userChap4.setId(id);
        userChap4.setUserName(userName);
        userChap4.setNote(note);
        UserValidator userValidator = (UserValidator)userService;
        if (userValidator.validate(userChap4)) {
            userService.printUser(userChap4);
        }
        return userChap4;
    }

    @RequestMapping("/manyAspects")
    public String manyAspects() {
        userService.manyAspects();
        return "manyAspects";
    }
}
