package org.netflix.discovery.shared;


import com.netflix.appinfo.InstanceInfo;

import java.util.List;

/**
 * 发现服务实例
 * 方便版本过度
 */
public interface LookupService<T> {

    /**
     * Application  根据服务实例注册的appName来获取封装有相同appName的服务实例信息容器
     *
     * @param appName
     * @return
     */
    Application getApplication(String appName);

    /**
     * 返回当前注册表中所有的服务实例信息
     *
     * @return
     */
    Applications getApplications();

    /**
     * 根据服务实例的id获取服务实例信息
     *
     * @param id
     * @return
     */
    List<InstanceInfo> getInstancesById(String id);

    InstanceInfo getNextServerFromEureka(String virtualHostname, boolean secure);
}
