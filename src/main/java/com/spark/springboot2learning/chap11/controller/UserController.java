package com.spark.springboot2learning.chap11.controller;

import com.spark.springboot2learning.chap11.enumeration.SexEnum;
import com.spark.springboot2learning.chap11.pojo.User;
import com.spark.springboot2learning.chap11.pojo.ValidatorPojo;
import com.spark.springboot2learning.chap11.service.UserService;
import com.spark.springboot2learning.chap11.validator.UserValidator;
import com.spark.springboot2learning.chap11.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author initiald0824
 * @date 2019/8/27 14:49
 */
@RestController
@Api("测试API")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    private User changeToPo(UserVo userVo) {
        User user = new User();
        user.setId(userVo.getId());
        user.setUserName(userVo.getUserName());
        user.setSex(SexEnum.getSexEnum(userVo.getSexCode()));
        user.setNote(userVo.getNote());
        return user;
    }

    private UserVo changeToVo (User user) {
        UserVo userVo = new UserVo();
        userVo.setId(user.getId());
        userVo.setUserName(user.getUserName());
        userVo.setSexCode(user.getSex().getCode());
        userVo.setSexName(user.getSex().getName());
        userVo.setNote(user.getNote());
        return userVo;
    }

    private List<UserVo> changeToVoes(List<User> poList) {
        List<UserVo> voList = new ArrayList<>();
        for (User user: poList) {
            UserVo userVo = changeToVo(user);
            voList.add(userVo);
        }
        return voList;
    }


    @GetMapping("/{id}")
    public User get(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/format/commit")
    public Map<String, Object> format(@DateTimeFormat(iso= DateTimeFormat.ISO.DATE) Date date,
                                      @NumberFormat(pattern = "#, ###.##") Double number) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("date", date);
        dataMap.put("number", number);
        return dataMap;
    }

    @GetMapping("/converter")
    public User getUserByConverter(User user) {
        return user;
    }

    @PostMapping("/valid/validate")
    @ApiOperation(value = "规则验证")
    @ApiImplicitParam(name = "vp", value = "ValidatorPojo", required = true, dataType = "ValidatorPojo")
    public Map<String, Object> validate(@Valid @RequestBody ValidatorPojo vp, Errors errors) {
        Map<String, Object> errMap = new HashMap<>();
        List<ObjectError> oes = errors.getAllErrors();

        for (ObjectError oe: oes) {
            String key = null;
            String msg = null;
            if (oe instanceof FieldError) {
                FieldError fe = (FieldError) oe;
                key = fe.getField();
            } else {
                key = oe.getObjectName();
            }
            msg = oe.getDefaultMessage();
            errMap.put(key, msg);
        }
        return errMap;
    }

    @GetMapping("/validator")
    public Map<String, Object> validator(@Valid User user, Errors errors, Date date) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("date", date);
        if (errors.hasErrors()) {
            List<ObjectError> oes = errors.getAllErrors();
            for (ObjectError oe: oes) {
                if (oe instanceof FieldError) {
                    FieldError fe = (FieldError) oe;
                    map.put(fe.getField(), fe.getDefaultMessage());
                } else {
                    map.put(oe.getObjectName(), oe.getDefaultMessage());
                }
            }
        }
        return map;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new UserValidator());
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }

}
