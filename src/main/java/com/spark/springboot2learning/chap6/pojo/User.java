package com.spark.springboot2learning.chap6.pojo;

import org.apache.ibatis.type.Alias;

/**
 * @author initiald0824
 * @date 2019/8/5 23:32
 */
@Alias("user")
public class User {
    private Long id;
    private String userName;
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}