package com.spark.springboot2learning.chap11.pojo;

import com.spark.springboot2learning.chap11.enumeration.SexEnum;
import org.apache.ibatis.type.Alias;

/**
 * @author initiald0824
 * @date 2019/8/26 23:56
 */
@Alias("user")
public class User {
    private Long id;
    private String userName;
    private SexEnum sex = null;
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

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}