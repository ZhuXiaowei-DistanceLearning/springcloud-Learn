package com.zxw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zxw
 * @date 2019/8/20 22:04
 */
@SpringBootApplication
@EnableEurekaClient
public class clientApplication {
    public static void main(String[] args) {
        SpringApplication.run(clientApplication.class);
    }
}

