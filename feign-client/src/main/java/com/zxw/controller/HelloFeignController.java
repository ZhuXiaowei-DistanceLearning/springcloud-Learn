package com.zxw.controller;

import com.zxw.service.HelloFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxw
 * @date 2019/8/22 21:39
 */
@RestController
public class HelloFeignController {
    @Autowired
    private HelloFeignService feignService;

    @GetMapping(value = "/search/github")
    public String searchGithubRepoByStr(@RequestParam("str") String queryStr) {
        return feignService.searchRepo(queryStr);
    }
}
