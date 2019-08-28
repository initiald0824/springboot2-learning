package com.spark.springboot2learning.chap13.pojo;

import java.io.Serializable;

/**
 * @author initiald0824
 * @date 2019/8/28 19:33
 */
public class User implements Serializable {

    private static final long serialVersionUID = 8081849731640304905L;

    private Long id;
    private String userName;
    private String note;

    public User(Long id, String userName, String note) {
        this.id = id;
        this.userName = userName;
        this.note = note;
    }

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
