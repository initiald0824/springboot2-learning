package com.spark.springboot2learning.chap11.service;

import com.spark.springboot2learning.chap11.pojo.User;

import java.util.List;

/**
 * @author initiald0824
 * @date 2019/8/27 14:34
 */
public interface UserService {

    public User insertUser(User user);

    public User getUser(Long id);

    public List<User> findUsers(String userName, String note, int start, int limit);

    public int updateUser(User user);

    public int updateUserName(Long id, String userName);

    public int deleteUser(Long id);
}
