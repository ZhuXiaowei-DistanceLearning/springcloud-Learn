package org.netflix.discovery;


import com.netflix.appinfo.HealthCheckCallback;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaEventListener;
import org.netflix.appinfo.ApplicationInfoManager;
import org.netflix.appinfo.HealthCheckHandler;
import org.netflix.discovery.shared.Application;
import org.netflix.discovery.shared.Applications;

import javax.inject.Provider;
import java.util.List;
import java.util.Set;

/**
 * 与Eureka Server交互的类
 * 注册服务实例到Eureka Server中
 * 发送心跳更新与Eureka Server的租约
 * 在服务关闭时从Eureka Server中取消租约，服务下线
 * 查询在Eureka Server中注册的服务实例列表
 */
public class DiscoveryClient implements EurekaClient {
    /**
     * 1.相关配置的赋值，类似ApplicationInfoManager、EurekaClientConfig
     * 2.备份注册中心的初始化，默认没有实现
     * 3.拉取Eureka Server 注册表中的信息
     * 4.注册前的预处理
     * 5.向Eureka Server注册自身
     * 6.初始化心跳定时任务、缓存刷新和按需注册等定时任务
     *
     * @param applicationInfoManager 信息管理器
     * @param config                 封装了Client与Server交互配置信息的类s
     * @param args                   用于注入可选参数
     * @param registryProvider       备份注册中心的原则
     */
    public DiscoveryClient(ApplicationInfoManager applicationInfoManager, EurekaClientConfig config, AbstractDiscoveryClientOptionalArgs args, Provider<BackupRegistry> registryProvider) {
        // 是否从Server中拉取注册表信息
        if (config.shouldFetchRegistry()) {

        }
        // 是否注册到Server中
        if (config.shouldRegisterWithEureka()) {

        }
    }

    @Override
    public Application getApplication(String appName) {
        return null;
    }

    @Override
    public Applications getApplications() {
        return null;
    }

    @Override
    public List<InstanceInfo> getInstancesById(String id) {
        return null;
    }

    @Override
    public InstanceInfo getNextServerFromEureka(String virtualHostname, boolean secure) {
        return null;
    }

    @Override
    public Applications getApplicationsForARegion(String region) {
        return null;
    }

    @Override
    public Applications getApplications(String serviceUrl) {
        return null;
    }

    @Override
    public List<InstanceInfo> getInstancesByVipAddress(String vipAddress, boolean secure) {
        return null;
    }

    @Override
    public List<InstanceInfo> getInstancesByVipAddress(String vipAddress, boolean secure, String region) {
        return null;
    }

    @Override
    public List<InstanceInfo> getInstancesByVipAddressAndAppName(String vipAddress, String appName, boolean secure) {
        return null;
    }

    @Override
    public Set<String> getAllKnownRegions() {
        return null;
    }

    @Override
    public InstanceInfo.InstanceStatus getInstanceRemoteStatus() {
        return null;
    }

    @Override
    public List<String> getDiscoveryServiceUrls(String zone) {
        return null;
    }

    @Override
    public List<String> getServiceUrlsFromConfig(String instanceZone, boolean preferSameZone) {
        return null;
    }

    @Override
    public List<String> getServiceUrlsFromDNS(String instanceZone, boolean preferSameZone) {
        return null;
    }

    @Override
    public void registerHealthCheckCallback(HealthCheckCallback callback) {

    }

    @Override
    public void registerHealthCheck(HealthCheckHandler healthCheckHandler) {

    }

    @Override
    public void registerEventListener(EurekaEventListener eventListener) {

    }

    @Override
    public boolean unregisterEventListener(EurekaEventListener eventListener) {
        return false;
    }

    @Override
    public void shutdown() {

    }

    @Override
    public EurekaClientConfig getEurekaClientConfig() {
        return null;
    }

    @Override
    public ApplicationInfoManager getApplicationInfoManager() {
        return null;
    }
}
