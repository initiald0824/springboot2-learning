package com.spark.springboot2learning.chap5.service;

import com.spark.springboot2learning.chap5.pojo.User;

import java.util.List;

/**
 * @author initiald0824
 * @date 2019/8/4 23:24
 */
public interface JdbcTmplUserService {
    public User getUser(Long id);

    public List<User> findUsers(String userName, String note);

    public int insertUser(User user);

    public int updateUser(User user);

    public int deleteUser(Long id);
}
