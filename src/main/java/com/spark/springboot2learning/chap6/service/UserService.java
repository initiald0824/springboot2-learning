package com.spark.springboot2learning.chap6.service;

import com.spark.springboot2learning.chap6.pojo.User;

/**
 * @author initiald0824
 * @date 2019/8/5 23:28
 */
public interface UserService {

    public User getUser(Long id);

    public int insertUser(User user);
}
