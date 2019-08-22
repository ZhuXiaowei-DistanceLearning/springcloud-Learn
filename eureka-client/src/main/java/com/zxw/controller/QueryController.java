package com.zxw.controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zxw
 * @date 2019/8/20 21:52
 */
@RestController
public class QueryController {
    @Autowired
    private EurekaClientConfigBean eurekaClientConfigBean;

    @GetMapping("/query")
    public Object getEurekaServerUrl() {
        return eurekaClientConfigBean.getServiceUrl();
    }

    @GetMapping("/add")
    public String add(Integer a, Integer b, HttpServletRequest request) {
        return "From Port:" + request.getServerPort() + ",Result:" + (a + b );
    }
}
