package com.spark.springboot2learning.chap8.service;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.spark.springboot2learning.chap8.pojo.User;

import java.util.List;

/**
 * @author initiald0824
 * @date 2019/8/10 1:58
 */
public interface UserService {

    public void saveUser(User user);

    public DeleteResult deleteUser(Long id);

    public List<User> findUser(String userName, String note, int skip, int limit);

    public UpdateResult updateUser(Long id, String userName, String note);

    public User getUser(Long id);
}
