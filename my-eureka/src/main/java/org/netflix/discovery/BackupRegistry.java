package org.netflix.discovery;

/**
 *   * <em> eureka </ em>客户的简单合约，以便获得回扣
 *   *如果eureka客户端无法检索此注册表信息
 *   *来自任何<em> eureka </ em>服务器的信息。
 *  *
 *   * <p>
 *   *这通常不是必需的，但适用于没有的应用程序
 *   *注册表信息，它可以提供一些额外的reslience。
 *   * </ p>
 *  *
 *   * 备份注册中心的职责，当Eureka Client无法从任何一个Eureka Server中获取注册表信息时，BackupRegister将被调用以获取注册表信息，默认实现是NotImplementedRegistryImpl
 *  *
 *  
 */
public interface BackupRegistry {
}
