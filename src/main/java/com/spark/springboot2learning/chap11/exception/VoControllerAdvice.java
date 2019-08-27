package com.spark.springboot2learning.chap11.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author initiald0824
 * @date 2019/8/27 9:23
 */
@ControllerAdvice(
        // 指定拦截包的控制器
        basePackages = { "com.spark.springboot2learning.chap11.controller.*" },
        annotations = { Controller.class, RestController.class }
)
public class VoControllerAdvice {
    /**
     * 异常处理，可以定义异常类型进行拦截处理
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(value = NotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> exception(HttpServletRequest request, NotFoundException ex) {
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("code", ex.getCode());
        msgMap.put("message", ex.getCustomMsg());
        return msgMap;
    }
}
