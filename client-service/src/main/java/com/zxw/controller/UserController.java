package com.zxw.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxw
 * @date 2019/8/22 20:45
 */
@RestController
public class UserController {
    @HystrixCommand(fallbackMethod = "defaultUser")
    @GetMapping("/getUser")
    public String getUser(String username) throws Exception {
        if (username.equals("spring")) {
            return "this is real user";
        } else {
            throw new Exception();
        }
    }

    public String defaultUser(String username) {
        return "The user dose not exist in this system";
    }
}
