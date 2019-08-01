package com.spark.springboot2learning.chap3.pojo;

import com.spark.springboot2learning.chap3.pojo.definition.Animal;
import org.springframework.stereotype.Component;

/**
 * @author initiald0824
 * @date 2019/8/1 15:17
 */

@Component
public class Dog implements Animal {
    @Override
    public void use() {
        System.out.println("狗【" + Dog.class.getSimpleName() + "】是看门用的。");
    }
}
