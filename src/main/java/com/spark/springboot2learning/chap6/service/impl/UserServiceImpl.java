package com.spark.springboot2learning.chap6.service.impl;

import com.spark.springboot2learning.chap6.dao.UserDao;
import com.spark.springboot2learning.chap6.pojo.User;
import com.spark.springboot2learning.chap6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author initiald0824
 * @date 2019/8/5 23:43
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao = null;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1, rollbackFor = Exception.class)
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1, rollbackFor = Exception.class)
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }
}
