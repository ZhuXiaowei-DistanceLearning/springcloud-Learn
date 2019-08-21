package org.netflix.discovery;

/**
 *   * eureka客户注册的配置信息
 *   *使用<em> Eureka </ em>服务器的实例。
 *  *
 *   * <p>
 *   *大多数必需信息由默认配置提供
 *   * { DefaultEurekaClientConfig}。 用户只需提供eureka
 *   *服务器服务网址。 Eureka服务器服务URL可以由2配置
 *   *机制
 *  *
 *   * 1）通过在DNS中注册信息。 2）通过在中指定它
 *   *配置。
 *   * </ p>
 *  *
 *  *
 *   *一旦客户注册，用户就可以查询信息
 *   * { EurekaClient}基于<em>虚拟主机名</ em>（也称为
 *   * VIPAddress），最常用的方式或通过其他方式获得
 *   *与注册的其他实例交谈所需的信息
 *   * <em> Eureka </ em>。
 *  *
 *   * <p>
 *   *请注意，除非和，否则所有配置在运行时都无效
 *   *另有说明。
 *   * </ p>
 *  *
 *   * 封装了Client与Server交互配置信息的类
 *  *
 *  
 */
public interface EurekaClientConfig {
    String getBackupRegistryImpl();

    /**
     * 是否从Eureka Server中拉取注册表信息
     *
     * @return
     */
    boolean shouldFetchRegistry();

    /**
     * 是否将Eureka Client注册到Eureka Server
     *
     * @return
     */
    boolean shouldRegisterWithEureka();

}
