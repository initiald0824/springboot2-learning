package com.spark.springboot2learning.chap7.pojo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author initiald0824
 * @date 2019/8/9 15:22
 */
@Alias("user")
public class User implements Serializable {
    private static final long serialVersionUID = 7760614561073458247L;
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
