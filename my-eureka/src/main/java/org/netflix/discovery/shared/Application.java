package org.netflix.discovery.shared;

import java.util.Random;

/**
 * 持有服务实例信息列表
 * 同一个服务的集群信息
 * 这些服务实例都挂在同一个服务名appName下
 * InstanceInfo 代表一个服务实例信息
 */
public class Application {
    private static Random shuffleRandom = new Random();

    private String name;
    private volatile boolean isDirty = false;
}

