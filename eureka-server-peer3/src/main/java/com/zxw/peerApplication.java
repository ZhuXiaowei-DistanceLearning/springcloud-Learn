package com.zxw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zxw
 * @date 2019/8/20 22:04
 */
@SpringBootApplication
@EnableEurekaServer
public class peerApplication {
    public static void main(String[] args) {
        SpringApplication.run(peerApplication.class);
    }
}

