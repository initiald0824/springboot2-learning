package com.spark.springboot2learning.chap5.service.impl;

import com.spark.springboot2learning.chap5.enumeration.SexEnum;
import com.spark.springboot2learning.chap5.pojo.User;
import com.spark.springboot2learning.chap5.service.JdbcTmplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author initiald0824
 * @date 2019/8/4 23:29
 */
public class JdbcTmpUserServiceImpl implements JdbcTmplUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate = null;

    /**
     * 获取映射关系
     * @return
     */
    private RowMapper<User> getUserMapper() {
        // 使用Lambda表达式创建用户映射关系
        RowMapper<User> userRowMapper = (ResultSet rs, int rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("user_name"));
            int sexId = rs.getInt("sex");
            SexEnum sex = SexEnum.getEnumById(sexId);
            user.setSex(sex);
            user.setNote(rs.getString("note"));
            return user;
        };
        return userRowMapper;
    }

    @Override
    public User getUser(Long id) {
        String sql = " select id, user_name, sex, note from t_user where id = ?";
        Object[] params = new Object[] {id};
        User user = jdbcTemplate.queryForObject(sql, params, getUserMapper());
        return user;
    }

    @Override
    public List<User> findUsers(String userName, String note) {
        String sql = " select id, user_name, sex, note from t_user "
                + "where user_name like concat('%', ?, '%') "
                + "and note like concat('%', ?, '%')";
        Object[] params = new Object[] {userName, note};
        return jdbcTemplate.query(sql, params, getUserMapper());
    }

    @Override
    public int insertUser(User user) {
        String sql = " insert into t_user (user_name, sex, note) values(?, ?, ?)";
        return jdbcTemplate.update(sql, user.getUserName(), user.getSex().getId(), user.getNote());
    }

    @Override
    public int updateUser(User user) {
        String sql = " update t_user set user_name = ?, sex = ?, note = ? " + " where id = ?";
        return jdbcTemplate.update(sql, user.getUserName(), user.getSex().getId(), user.getNote(), user.getId());
    }

    @Override
    public int deleteUser(Long id) {
        String sql = " delete from t_user where id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
