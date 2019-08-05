package com.spark.springboot2learning.chap5.dao;

import com.spark.springboot2learning.chap5.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author initiald0824
 * @date 2019/8/5 12:15
 */
public interface JpaUserRepository extends JpaRepository<User, Long> {

    @Query("from user where user_name like concat('%', ?1, '%') " + "and note like concat('', ?2, '%')")
    public List<User> findUsers(String userName, String note);
}
