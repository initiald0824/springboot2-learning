package com.spark.springboot2learning.chap11.vo;

/**
 * @author initiald0824
 * @date 2019/8/27 17:44
 */
public class ResultVo {
    private Boolean success = null;
    private String message = null;

    public ResultVo() {
    }

    public ResultVo(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
