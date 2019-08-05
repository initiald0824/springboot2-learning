package com.spark.springboot2learning.chap5.converter;

import com.spark.springboot2learning.chap5.enumeration.SexEnum;

import javax.persistence.AttributeConverter;

/**
 * @author initiald0824
 * @date 2019/8/5 12:12
 */
public class SexConverter implements AttributeConverter<SexEnum, Integer> {

    /**
     * 将枚举类型转为数据库列
     * @param sexEnum
     * @return
     */
    @Override
    public Integer convertToDatabaseColumn(SexEnum sexEnum) {
        return sexEnum.getId();
    }

    /**
     * 将数据库列转为枚举类型
     * @param integer
     * @return
     */
    @Override
    public SexEnum convertToEntityAttribute(Integer integer) {
        return SexEnum.getEnumById(integer);
    }
}
