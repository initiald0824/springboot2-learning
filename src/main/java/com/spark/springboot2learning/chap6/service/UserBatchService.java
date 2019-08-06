package com.spark.springboot2learning.chap6.service;

import com.spark.springboot2learning.chap6.pojo.User;

import java.util.List;

/**
 * @author initiald0824
 * @date 2019/8/6 14:55
 */
public interface UserBatchService {
    public int insertUsers(List<User> userList);
}
