package com.spark.springboot2learning.chap14.controller;

import com.spark.springboot2learning.chap14.pojo.User;
import com.spark.springboot2learning.chap14.service.UserService;
import com.spark.springboot2learning.chap14.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author initiald0824
 * @date 8/29/2019 4:50 PM
 */

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public Mono<UserVo> getUser(@PathVariable Long id) {
        return userService.getUser(id)
                .map(this::translate);
    }

    @PostMapping("/user")
    public Mono<UserVo> insertUser(@RequestBody User user) {
        return userService.insertUser(user).map(this::translate);
    }

    @PutMapping("/user")
    public Mono<UserVo> updateUser(@RequestBody User user) {
        return userService.updateUser(user).map(this::translate);
    }

    @DeleteMapping("/user/{id}")
    public Mono<Void> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/user/{userName}/{note}")
    public Flux<UserVo> findUsers(@PathVariable String userName, @PathVariable String note) {
        return userService.findUsers(userName, note).map(this::translate);
    }

    @PostMapping("/user2/{user}")
    public Mono<UserVo> insertUser2(@PathVariable("user") User user) {
        return userService.insertUser(user).map(this::translate);
    }



    private UserVo translate(User user) {
        UserVo userVo = new UserVo();
        userVo.setUserName(user.getUserName());
        userVo.setSexCode(user.getSex().getCode());
        userVo.setSexName(user.getSex().getName());
        userVo.setNote(user.getNote());
        userVo.setId(user.getId());
        return userVo;
    }
}
