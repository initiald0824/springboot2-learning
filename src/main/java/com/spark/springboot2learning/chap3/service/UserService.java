package com.spark.springboot2learning.chap3.service;

import com.spark.springboot2learning.chap3.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author initiald0824
 * @date 2019/8/1 14:23
 */
@Service
public class UserService {
    public void printUser(User user) {
        System.out.println("编号：" + user.getId());
        System.out.println("用户名称: " + user.getUserName());
        System.out.println("备注：" + user.getNote());
    }
}
