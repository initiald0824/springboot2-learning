package com.spark.springboot2learning.chap11.service.impl;

import com.spark.springboot2learning.chap11.dao.UserDao;
import com.spark.springboot2learning.chap11.pojo.User;
import com.spark.springboot2learning.chap11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author initiald0824
 * @date 2019/8/27 14:35
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User insertUser(User user) {
        return userDao.insertUser(user) > 0 ? user : null;
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> findUsers(String userName, String note, int start, int limit) {
        return userDao.findUsers(userName, note, start, limit);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int updateUserName(Long id, String userName) {
        return userDao.updateUserName(id, userName);
    }

    @Override
    public int deleteUser(Long id) {
        return userDao.deleteUser(id);
    }
}
