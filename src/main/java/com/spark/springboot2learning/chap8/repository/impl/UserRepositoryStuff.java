package com.spark.springboot2learning.chap8.repository.impl;

import com.spark.springboot2learning.chap8.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @author initiald0824
 * @date 2019/8/10 11:38
 */
public class UserRepositoryStuff {

    @Autowired
    private MongoTemplate mongoTemplate = null;

    public User findUserByIdOrUserName(Long id, String userName) {
        Criteria criteriaId = Criteria.where("id").is(id);

        Criteria criteriaUserName = Criteria.where("user_name").is(userName);

        Criteria criteria = new Criteria();

        criteria.orOperator(criteriaId, criteriaUserName);

        Query query = Query.query(criteria);

        return mongoTemplate.findOne(query, User.class);
    }
}
