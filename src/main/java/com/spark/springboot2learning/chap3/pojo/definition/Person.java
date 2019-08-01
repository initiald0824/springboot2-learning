package com.spark.springboot2learning.chap3.pojo.definition;

/**
 * @author initiald0824
 * @date 2019/8/1 14:49
 */
public interface Person {
    /**
     * 使用动物服务
     */
    public void service();

    /**
     * 设置动物
      * @param animal
     */
    public void setAnimal(Animal animal);
}
