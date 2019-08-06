package com.spark.springboot2learning.chap6.service.impl;

import com.spark.springboot2learning.chap6.pojo.User;
import com.spark.springboot2learning.chap6.service.UserBatchService;
import com.spark.springboot2learning.chap6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author initiald0824
 * @date 2019/8/6 14:56
 */
@Service
public class UserBatchServiceImpl implements UserBatchService {

    @Autowired
    private UserService userService = null;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insertUsers(List<User> userList) {
        int count = 0;
        for (User user: userList) {
            // 调用子方法，将使用@Transactional定义的传播行为
            count += userService.insertUser(user);
        }
        return count;
    }
}
