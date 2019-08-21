package com.spark.springboot2learning.chap8.repository;

import com.spark.springboot2learning.chap8.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author initiald0824
 * @date 2019/8/10 11:24
 */
public interface UserRepository extends MongoRepository<User, Long> {

    /**
     * 符合JPA规范命名的方法，则不需要再实现该方法也可用，
     * 对满足条件的文档按照用户名称进行模糊查询
     * @param userName
     * @return 满足条件的信息
     */
    List<User> findByUserNameLike(String userName);

    /**
     * 更加编号或者用户名查找用户
     * @param id
     * @param userName
     * @return 用户信息
     */
    User findUserByIdOrUserName(Long id, String userName);
}
