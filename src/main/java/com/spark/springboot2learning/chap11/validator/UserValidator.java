package com.spark.springboot2learning.chap11.validator;

import com.spark.springboot2learning.chap11.pojo.User;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author initiald0824
 * @date 2019/8/27 0:11
 */
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (o == null) {
            // 直接在参数处报错，这样就不能进入控制器的方法了
            errors.rejectValue("", null, "用户不能为空");
            return;
        }

        // 强制转换
        User user = (User)o;

        // 用户名非空串
        if (StringUtils.isEmpty(user.getUserName())) {
            // 增加错误，可以进入控制器方法
            errors.rejectValue("userName", null, "用户名不能为空");
        }
    }
}
