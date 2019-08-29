package com.spark.springboot2learning.chap14.repository;

import com.spark.springboot2learning.chap14.pojo.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @author initiald0824
 * @date 8/29/2019 4:40 PM
 */
@Repository
public interface UserRepository extends ReactiveMongoRepository<User, Long> {

    /**
     * 对用户名和备注进行模糊查询
     * @param userName 用户名
     * @param note 备注
     * @return 符合条件的用户
     */
    public Flux<User> findByUserNameLikeAndNoteLike(
            String userName, String note);
}
