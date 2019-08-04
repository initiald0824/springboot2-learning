package com.spark.springboot2learning.chap4.aspect.validator.impl;

import com.spark.springboot2learning.chap3.pojo.UserChap4;
import com.spark.springboot2learning.chap4.aspect.validator.UserValidator;

/**
 * @author initiald0824
 * @date 2019/8/4 14:51
 */
public class UserValidatorImpl implements UserValidator {
    @Override
    public boolean validate(UserChap4 userChap4) {
        System.out.println("引入新接口：" + UserValidator.class.getSimpleName());
        return userChap4 != null;
    }
}
