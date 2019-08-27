package com.spark.springboot2learning.chap11.pojo;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @author initiald0824
 * @date 2019/8/27 7:45
 */
public class ValidatorPojo {

    @NotNull(message = "id不能为空")
    private Long id;

    @Future(message = "需要一个将来日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date date;

    @NotNull
    @DecimalMin(value = "0.1")
    @DecimalMax(value = "10000.00")
    private Double doubleValue = null;

    @Min(value = 1, message = "最小值为1")
    @Max(value = 88, message = "最大值为88")
    @NotNull
    private Integer integer;

    @Range(min = 1, max = 888, message = "范围为1至888")
    private Long range;

    @Email(message = "邮箱格式化错误")
    private String email;

    @Size(min = 20, max = 30, message = "字符串长度要求20到30之间。")
    private String size;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public Long getRange() {
        return range;
    }

    public void setRange(Long range) {
        this.range = range;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
