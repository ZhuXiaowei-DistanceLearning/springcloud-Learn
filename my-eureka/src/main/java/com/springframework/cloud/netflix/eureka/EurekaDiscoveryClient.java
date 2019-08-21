package com.springframework.cloud.netflix.eureka;

import com.netflix.appinfo.EurekaInstanceConfig;
import com.springframework.cloud.client.discovery.DiscoveryClient;
import org.bouncycastle.jcajce.provider.symmetric.DES;
import org.netflix.discovery.EurekaClient;
import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Created by zxw on 2019/7/9.
 * springcloud通过组合的方式调用了Eureka中的服务发现的方法
 */
public class EurekaDiscoveryClient implements DiscoveryClient {
    private EurekaClient eurekaClient;
    private static final String DESCRIPTION = "Spring Cloud eureka 发现客户端";
    private final EurekaInstanceConfig config;

    public EurekaDiscoveryClient(EurekaClient eurekaClient, EurekaInstanceConfig config) {
        this.eurekaClient = eurekaClient;
        this.config = config;
    }

    @Override
    public String description() {
        return DESCRIPTION;
    }

    @Override
    public List<ServiceInstance> getInstances(String serviceId) {
        return null;
    }

    @Override
    public List<String> getServices() {
        return null;
    }
}
