package org.netflix.discovery;

import org.netflix.appinfo.ApplicationInfoManager;

import javax.inject.Provider;

/**
 * Created by zxw on 2019/7/9.
 */
public class CloudEurekaClient extends DiscoveryClient {
    /**
     * @param applicationInfoManager 信息管理器
     * @param config                 封装了Client与Server交互配置信息的类s
     * @param args                   用于注入可选参数
     * @param registryProvider       备份注册中心的原则
     */
    public CloudEurekaClient(ApplicationInfoManager applicationInfoManager, EurekaClientConfig config, AbstractDiscoveryClientOptionalArgs args, Provider<BackupRegistry> registryProvider) {
        super(applicationInfoManager, config, args, registryProvider);
    }
}
