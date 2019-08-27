package com.spark.springboot2learning.chap11.dao;

import com.spark.springboot2learning.chap11.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author initiald0824
 * @date 2019/8/27 14:10
 */
@Mapper
public interface UserDao {

    public User getUser(Long id);

    public int insertUser(User user);

    public List<User> findUsers(@Param("userName") String userName, @Param("note") String note, @Param("start") int start, @Param("limit") int limit);

    public int updateUser(User user);

    public int updateUserName(@Param("id") Long id, @Param("userName") String userName);

    public int deleteUser(Long id);
}
