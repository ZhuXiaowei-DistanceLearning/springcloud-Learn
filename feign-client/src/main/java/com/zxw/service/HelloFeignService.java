package com.zxw.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zxw
 * @date 2019/8/22 21:37
 */
@FeignClient(name = "github-client", url = "https://api.github.com")
public interface HelloFeignService {
    @RequestMapping("/search/repositories")
    public String searchRepo(@RequestParam("q") String queryStr);
}
