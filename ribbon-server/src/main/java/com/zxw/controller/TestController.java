package com.zxw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zxw
 * @date 2019/8/22 19:57
 */
@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/add")
    public String add(Integer a, Integer b) {
        String template = restTemplate.getForObject("http://CLIENT-A/add/a=" + a + "&b=" + b, String.class);
        return template;
    }
}
