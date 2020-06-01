package com.aloneness.well.framework.test.controller;

import com.aloneness.well.framework.response.NotWrap;
import com.aloneness.well.framework.test.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello 测试
 *
 * @author aloneness
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/user")
    @NotWrap
    public User user() {
        User user = new User();
        user.setName("tong");
        user.setAge(12);
        return user;
    }

    @GetMapping("/num")
    public Integer num(){
        return 1;
    }
}
