package com.spark.springboot2learning.chap6.dao;

import com.spark.springboot2learning.chap6.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author initiald0824
 * @date 2019/8/5 23:45
 */
@Repository
public interface UserDao {
    User getUser(Long id);
    int insertUser(User user);
}
