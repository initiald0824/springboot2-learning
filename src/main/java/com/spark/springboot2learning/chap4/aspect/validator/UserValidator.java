package com.spark.springboot2learning.chap4.aspect.validator;

import com.spark.springboot2learning.chap3.pojo.UserChap4;

/**
 * @author initiald0824
 * @date 2019/8/4 14:49
 */
public interface UserValidator {
    /**
     * 检查对象是否为空
     * @param userChap4
     * @return
     */
    public boolean validate(UserChap4 userChap4);
}
