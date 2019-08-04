package com.spark.springboot2learning.chap5.enumeration;

/**
 * @author initiald0824
 * @date 2019/8/4 23:19
 */
public enum SexEnum {
    /**
     * MALE 1 男
     * FEMALE 2 女
     */
    MALE(1, "男"),
    FEMALE(2, "女");

    private int id;

    private String name;

    SexEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static SexEnum getEnumById(int id) {
        for (SexEnum sex: SexEnum.values()) {
            if (sex.getId() == id) {
                return sex;
            }
        }
        return null;
    }

}
