package com.zxw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @author zxw
 * @date 2019/8/21 21:24
 */
@SpringBootApplication
public class SpringCloudGatewayApplication {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes().route(r -> r.path("/jd").uri("http://jd.com:80/").id("jd_route")).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewayApplication.class);
    }
}
