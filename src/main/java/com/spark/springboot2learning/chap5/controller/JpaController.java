package com.spark.springboot2learning.chap5.controller;

import com.spark.springboot2learning.chap5.dao.JpaUserRepository;
import com.spark.springboot2learning.chap5.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author initiald0824
 * @date 2019/8/5 12:16
 */

@RestController
@RequestMapping("/jpa")
public class JpaController {

    @Autowired
    private JpaUserRepository jpaUserRepository = null;

    @RequestMapping("/getUser")
    public User getUser(Long id) {
        return jpaUserRepository.findById(id).get();
    }
}
