package com.spark.springboot2learning.chap14.service.impl;

import com.spark.springboot2learning.chap14.pojo.User;
import com.spark.springboot2learning.chap14.repository.UserRepository;
import com.spark.springboot2learning.chap14.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author initiald0824
 * @date 8/29/2019 4:46 PM
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Mono<User> insertUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<User> updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<Void> deleteUser(Long id) {
        return userRepository.deleteById(id);
    }

    @Override
    public Flux<User> findUsers(String userName, String note) {
        return userRepository.findByUserNameLikeAndNoteLike(userName, note);
    }
}
