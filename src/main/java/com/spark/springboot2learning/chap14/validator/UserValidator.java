package com.spark.springboot2learning.chap14.validator;


import com.spark.springboot2learning.chap14.pojo.User;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author initiald0824
 * @date 8/29/2019 5:09 PM
 */
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        // 监测用户名是否为空
        if (StringUtils.isEmpty(user.getUserName())) {
            errors.rejectValue("userName", null, "用户名不能为空");
        }
    }
}
