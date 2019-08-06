package com.spark.springboot2learning.chap6.service.impl;

import com.spark.springboot2learning.chap6.dao.UserDao;
import com.spark.springboot2learning.chap6.pojo.User;
import com.spark.springboot2learning.chap6.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author initiald0824
 * @date 2019/8/5 23:43
 */

@Service
public class UserServiceImpl implements UserService, ApplicationContextAware {

    @Autowired
    private UserDao userDao = null;

    private ApplicationContext applicationContext = null;

    /**
     * 实现生命周期的方法，设置IoC容器
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, timeout = 1, rollbackFor = Exception.class)
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, timeout = 1, rollbackFor = Exception.class)
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insertUsers(List<User> userList) {
        int count = 0;
        // 从IoC容器中取出代理对象
        UserService userService = applicationContext.getBean(UserService.class);

        for (User user: userList) {
            // 使用代理对象调用方法插入用户，此时会织入Spring数据库事务流程中
            count += userService.insertUser(user);
        }
        return count;
    }
}
