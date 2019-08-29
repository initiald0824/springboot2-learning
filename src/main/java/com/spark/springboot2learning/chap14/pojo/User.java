package com.spark.springboot2learning.chap14.pojo;

import com.spark.springboot2learning.chap14.enumeration.SexEnum;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author initiald0824
 * @date 8/29/2019 4:33 PM
 */
public class User implements Serializable {
    private static final long serialVersionUID = 3923229573077975377L;

    @Id
    private Long id;

    private SexEnum sex;

    @Field("user_name")
    private String userName;

    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
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
