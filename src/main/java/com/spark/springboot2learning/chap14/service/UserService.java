package com.spark.springboot2learning.chap14.service;

import com.spark.springboot2learning.chap14.pojo.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author initiald0824
 * @date 8/29/2019 4:43 PM
 */
public interface UserService {

    /**
     * 获取用户
     * @param id 用户ID
     * @return 获取用户
     */
    Mono<User> getUser(Long id);

    /**
     * 插入用户
     * @param user 用户信息
     * @return 用户信息
     */
    Mono<User> insertUser(User user);

    /**
     * 更新用户
     * @param user 用户信息
     * @return 用户信息
     */
    Mono<User> updateUser(User user);

    /**
     * 删除用户
     * @param id 用户ID
     * @return 空
     */
    Mono<Void> deleteUser(Long id);

    /**
     * 查询用户
     * @param userName 用户名
     * @param note 备注
     * @return 查询到的用户
     */
    Flux<User> findUsers(String userName, String note);
}
