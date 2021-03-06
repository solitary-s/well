package com.aloneness.well.framework.test.controller;

import com.aloneness.well.framework.response.NotWrap;
import com.aloneness.well.framework.test.domain.User;
import com.aloneness.well.framework.test.exception.CustomException;
import com.aloneness.well.framework.test.exception.TestException;
import com.aloneness.well.framework.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * hello 测试
 *
 * @author aloneness
 */
@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        throw new CustomException();
    }

    @GetMapping("/user")
    @NotWrap
    public User user() {
        User user = new User();
        user.setName("tong");
        user.setAge(12);
        user.setLocalDateTime(LocalDateTime.now());
        user.setLocalDate(LocalDate.now());
        user.setLocalTime(LocalTime.now());
        user.setBigNum(12121212L);
        return user;
    }

    @GetMapping("/num")
    public Integer num(){
        userService.user();
        return 1;
    }
}
