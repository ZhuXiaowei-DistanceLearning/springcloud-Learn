package com.zxw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zxw
 * @date 2019/8/22 21:36
 */
@SpringBootApplication
@EnableFeignClients
public class SpringCloudFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeignApplication.class);
    }
}
