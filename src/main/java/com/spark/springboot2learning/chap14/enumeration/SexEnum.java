package com.spark.springboot2learning.chap14.enumeration;

/**
 * @author initiald0824
 * @date 8/29/2019 4:33 PM
 */
public enum SexEnum {
    /**
     * 男
     */
    MALE(1, "男"),
    /**
     * 女
     */
    FEMALE(0, "女");

    private int code;
    private String name;

    SexEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static SexEnum getSexEnum (int code) {
        for (SexEnum sexEnum: SexEnum.values()) {
            if (sexEnum.getCode() == code) {
                return sexEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
