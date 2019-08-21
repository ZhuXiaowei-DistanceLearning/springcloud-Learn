package org.netflix.discovery;


import com.netflix.appinfo.HealthCheckCallback;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaEventListener;
import org.netflix.appinfo.ApplicationInfoManager;
import org.netflix.appinfo.HealthCheckHandler;
import org.netflix.discovery.shared.Applications;
import org.netflix.discovery.shared.LookupService;

import java.util.List;
import java.util.Set;

/**
 * 服务发现的顶级接口
 * Eureka Client注册到Server上、续租、下线以及获取Server中注册表信息等诸多功能
 * - 提供获取InstanceInfo的能力（以各种不同的方式）
 * - 提供获取有关本地客户端的数据的能力（已知区域，自己的AZ等）
 * - 提供注册和访问客户端的运行状况检查处理程序的功能
 */
public interface EurekaClient extends LookupService {
    public Applications getApplicationsForARegion(String region);

    public Applications getApplications(String serviceUrl);

    public List<InstanceInfo> getInstancesByVipAddress(String vipAddress, boolean secure);

    public List<InstanceInfo> getInstancesByVipAddress(String vipAddress, boolean secure, String region);

    public List<InstanceInfo> getInstancesByVipAddressAndAppName(String vipAddress, String appName, boolean secure);

    public Set<String> getAllKnownRegions();

    public InstanceInfo.InstanceStatus getInstanceRemoteStatus();

    @Deprecated
    public List<String> getDiscoveryServiceUrls(String zone);

    @Deprecated
    public List<String> getServiceUrlsFromConfig(String instanceZone, boolean preferSameZone);

    @Deprecated
    public List<String> getServiceUrlsFromDNS(String instanceZone, boolean preferSameZone);

    @Deprecated
    public void registerHealthCheckCallback(HealthCheckCallback callback);

    // 为Eureka Client注册健康检查处理器
    public void registerHealthCheck(HealthCheckHandler healthCheckHandler);

    // 监听Client服务实例信息的更新
    public void registerEventListener(EurekaEventListener eventListener);

    public boolean unregisterEventListener(EurekaEventListener eventListener);

    public void shutdown();

    public EurekaClientConfig getEurekaClientConfig();

    public ApplicationInfoManager getApplicationInfoManager();
}
