package com.zxw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zxw
 * @date 2019/8/20 21:52
 */
@Controller
@RequestMapping("/query")
public class QueryController {
    @Autowired
    private EurekaClientConfigBean eurekaClientConfigBean;

    @GetMapping("/eureka-server")
    public Object getEurekaServerUrl() {
        return eurekaClientConfigBean.getServiceUrl();
    }
}
