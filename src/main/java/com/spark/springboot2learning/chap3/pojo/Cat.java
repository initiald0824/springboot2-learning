package com.spark.springboot2learning.chap3.pojo;

import com.spark.springboot2learning.chap3.pojo.definition.Animal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author initiald0824
 * @date 2019/8/1 15:25
 */
@Component
public class Cat implements Animal {
    @Override
    public void use() {
        System.out.println("猫【" + Cat.class.getSimpleName() + "】是抓老鼠");
    }
}
