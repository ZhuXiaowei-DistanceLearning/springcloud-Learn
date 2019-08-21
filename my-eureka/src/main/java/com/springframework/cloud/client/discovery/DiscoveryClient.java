package com.springframework.cloud.client.discovery;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Created by zxw on 2019/7/9.
 * 进行服务发现的顶级接口
 */
public interface DiscoveryClient {
    // 获取实现类的描述
    String description();

    // 通过服务ID获取服务实例的信息
    List<ServiceInstance> getInstances(String serviceId);

    // 获取所有的服务实例ID
    List<String> getServices();

}
