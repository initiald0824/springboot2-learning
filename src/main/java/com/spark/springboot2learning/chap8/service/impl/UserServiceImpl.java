package com.spark.springboot2learning.chap8.service.impl;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.spark.springboot2learning.chap8.pojo.User;
import com.spark.springboot2learning.chap8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author initiald0824
 * @date 2019/8/10 1:58
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MongoTemplate mongoTemplate = null;

    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user, "user");
    }

    @Override
    public DeleteResult deleteUser(Long id) {
        Criteria criteriaId = Criteria.where("id").is(id);
        Query queryId = Query.query(criteriaId);
        DeleteResult result = mongoTemplate.remove(queryId, User.class);
        return result;
    }

    @Override
    public List<User> findUser(String userName, String note, int skip, int limit) {
        // 根据用户名称和备注设置为模糊查询准则
        Criteria criteria = Criteria.where("user_name").regex(userName).and("note").regex(note);
        // 构建查询条件，并设置分页跳过前skip个，至多返回limit个
        Query query = Query.query(criteria).limit(limit).skip(skip);
        List<User> userList = mongoTemplate.find(query, User.class);
        return userList;
    }

    @Override
    public UpdateResult updateUser(Long id, String userName, String note) {
        Criteria criteriaId = Criteria.where("id").is(id);
        Query query = Query.query(criteriaId);
        // 定义更新对象，后续可变化的字符串代表排除在外的属性
        Update update = Update.update("user_name", userName);
        update.set("note", note);

        UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);
        return result;
    }

    @Override
    public User getUser(Long id) {
        return mongoTemplate.findById(id, User.class);
    }
}
