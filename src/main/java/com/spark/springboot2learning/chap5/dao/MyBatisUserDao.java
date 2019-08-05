package com.spark.springboot2learning.chap5.dao;

import com.spark.springboot2learning.chap5.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author initiald0824
 * @date 2019/8/5 20:08
 */
@Repository
public interface MyBatisUserDao {
    public User getUser(Long id);
}
