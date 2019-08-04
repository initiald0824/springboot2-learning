package com.spark.springboot2learning.chap4.aspect.service.impl;

import com.spark.springboot2learning.chap3.pojo.UserChap4;
import com.spark.springboot2learning.chap4.aspect.service.UserService;
import org.springframework.stereotype.Component;

/**
 * @author initiald0824
 * @date 2019/8/3 15:52
 */
@Component
public class UserServiceImpl implements UserService {
    @Override
    public void printUser(UserChap4 userChap4) {
        if (userChap4 == null) {
            throw new RuntimeException("检查用户参数是否为空");
        }
        System.out.println("id = " + userChap4.getId());
        System.out.println("\tusername = " + userChap4.getUserName());
        System.out.println("\tnote = " + userChap4.getNote());
    }

    @Override
    public void manyAspects() {
        System.out.println("测试多个切面顺序");
    }
}
