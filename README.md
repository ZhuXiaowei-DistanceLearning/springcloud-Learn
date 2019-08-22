# SpringCloud教程



## 1.Eureka

### 1.1 Client端

1. ![1566307391459](C:\Users\zxw\Desktop\个人项目笔记\SpringCloud教程.assets\1566307391459.png)
2. ![1566307429515](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566307429515-1566482453498.png)
3. ![1566307437933](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566307437933-1566482453498.png)

### 1.2 Server端

1. ![1566307463470](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566307463470-1566482453498.png)
2. ![1566307479418](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566307479418-1566482453498.png)
3. ![1566307541474](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566307541474-1566482453499.png)

## 2.Zuul

1. 简介

   1. 基于JVM路由和服务端的负载均衡器
   2. zuul的核心是过滤器
      1. 动态路由
      2. 请求监控
      3. 认证授权
      4. 压力测试
      5. 灰度发布
   3. 过滤器类型
      1. pre:请求前被调用
      2. route:请求时被调用，适用灰度发布场景
      3. post:在route和error之后被调用，将请求路由到达具体的服务之后执行。适用于需要添加响应头，记录响应日志等场景
      4. error:处理请求时发生错误时被调用。在执行过程中发送错误时会进入error过滤器。
      5. ![1566386001738](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566386001738-1566482453499.png)

2. 典型配置

   1. 单实例

      ```yml
      zuul:
      	routes:
      		client-a:
      			path: /client/**
      			servicedId: client-a
      		client-a: /client/**
      		client-a: #默认的映射规则/client-a/**,相当于第一种方式
      ```

   2. 单实例url映射

      ```yml
      zuul:
      	routes:
      		client-a:
      			path: /client/**
      			url: http://localhost:7070
      ```

   3. 多实例路由

      1. 使用Eureka中继承的基本负载均衡功能，如果要使用Ribbon，需要指定一个serviceId，此操作需要禁止Ribbon使用eureka

      ```yml
      zuul:
      	routes:
      		client-a:
      			path: /client/**
      			servicedId: client-a
      ribbon:
      	eureka:
      		enable: false #禁止ribbon使用eureka
      ribbon-route:
      	ribbon:
      		xx:xxx
      ```

   4. forward本地跳转

      ```java
      @GetMapping("/client") // 跳转到该方法上
      public String add(Integer a,Integer b){
          return "本地跳转:"+(a+b);
      }
      ```

      ```yml
      zuul:
      	routes:
      		client-a:
      			path: /client/**
      			url: forward:/client
      ```

   5. 相同路径的加载规则

      ```yml
      zuul:
      	routes:
      		client-a:
      			path: /client/**
      			url: forward:/client-a
      		client-b: # 总是加载最末的服务
      			path: /client/**
      			url: forward:/client-b
      ```

   6. 路由通配符

      ```
      /**
      /*
      /?
      ```

      ![1566388557106](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566388557106-1566482453499.png)

3. 功能配置

   1. 路由前缀：

      ```yml
      zuul:
      	prefix: /pre
      	routes:
      		client-a:
      			path: /client/**
      			url: forward:/client-a
      			stripPrefix: false # 关闭路由前缀
      ```

   2. 服务屏蔽与路径屏蔽

      ```yml
      zuul:
      	prefix: /pre
      	ignored-services: client-b #忽略的服务，防服务侵入
      	ignored-patterns: /**/div/** #忽略的接口，屏蔽接口
      	routes:
      		client-a:
      			path: /client/**
      			url: forward:/client-a
      
      ```

   3. 敏感头信息

      ```yml
      zuul:
      	prefix: /pre
      	routes:
      		client-a:
      			path: /client/**
      			url: forward:/client-a
      			sensitiveHeaders: Cookie,Set-Cookie,Authorization
      
      ```

   4. 重定向问题

      ```yml
      zuul:
      	add-host-header: true #host为zuul的host
      
      ```

   5. 重试机制(默认继承Ribbon)

      ```yml
      zuul:
      	retryable: true #开启重试
      ribbon:
      	MaxAutoRetries: 1 # 同一个服务重试的次数(除去首次)
      	MaxAutoRetriesNextServer: 1 # 切换相同服务数量
      	ConnectTimeout: 250 # 连接超时时间(ms)
        	ReadTimeout: 2000 # 通信超时时间(ms)
        	OkToRetryOnAllOperations: true # 是否对所有操作重试
       spring:
       	cloud:
       		loadblancer:
       			retry:
       				enable: true #内部默认已开启，这里列出来说明这个参数比较重要
      
      ```

4. 容错机制

   1. ![1566386680753](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566386680753-1566482453499.png)

5. 回退机制

   1. zuul默认整合了 Hystrix
   2. 实现ZuulFallbackProvider接口

6. 高可用

   1. ![1566386825225](C:\Users\zxw\Desktop\个人项目笔记\SpringCloud教程.assets\1566386825225.png)

7. zuul+OAuth2.0+JWT

   1. OAuth2.0面向资源授权协议
   2. ![1566390145458](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566390145458-1566482453499.png)
   3. ![1566390189521](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566390189521-1566482453499.png)
   4. @EnableOAuth2Sso

8. zuul限流

   1. 限流算法
      1. 漏桶(Leaky Bucket)
      2. 令牌桶(Token Bucket)

9. 动态路由

   1. ![1566391286396](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566391286396-1566482453499.png)

10. 灰度发布

    1. 系统迭代新功能时的一种平滑过渡的上线方式。
    2. 在原有系统的基础上，额外增加一个新版本，这个新版本包含我们需要待验证的新功能，随后用负载均衡器引入一小部分流量到这个新版本应用，如果整个过程没有出现任何差错，在平滑地把线上系统或服务一步步替换成新版本，至此完成一次灰度发布。

11. 饥饿加载

    1. 默认使用Ribbon来调用远程服务，所以由于Ribbon的原因，第一次经过Zuul的调用往往会去注册中心读取服务注册表，初始化Ribbon负载信息，这是一种懒加载策略。

       ```yml
       zuul: # 开启饥饿加载
       	ribbon:
       		eager-load:
       			enable: true
       
       ```

12. 请求体修改

    1. ![1566391877126](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566391877126-1566482453499.png)
    2. ![1566391917221](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566391917221-1566482453499.png)

13. 使用okhttp替换HttpClient

    1. <dependency>

       ```yml
       ribbon:
       	httpclient:
       		enable: false
       	okhttp:
       		enable: true
       
       ```

14. Header传递

    1. Zuul中对请求做了一些处理，需要把处理结果发给下游服务，但是又不能影响请求体的原始特性

       ```java
       RequestContext context = RequestContext.getCurrentContext();
       context.addZuulRequestHeader("result","to next service")
       
       ```

15. Swagger2整合

    1. ```java
       @Configuration
       @EnableSwagger2
       public class SwaggerConfig {
           @Autowired
           ZuulProperties zuulProperties;
       
           @Primary
           @Bean
           public SwaggerResourcesProvider swaggerResourcesProvider() {
               return () -> {
                   List<SwaggerResource> resources = new ArrayList<>();
                   zuulProperties.getRoutes().values().stream()
                           .forEach(route -> resources
                                   .add(createResource(route.getServiceId(), route.getServiceId(), "2.0")));
                   return resources;
               };
           }
       
           private SwaggerResource createResource(String name, String location, String version) {
               SwaggerResource swaggerResource = new SwaggerResource();
               swaggerResource.setName(name);
               swaggerResource.setLocation("/" + location + "/v2/api-docs");
               swaggerResource.setSwaggerVersion(version);
               return swaggerResource;
           }
       }
       
       ```

### 2.1 多层负载

1. ![1566392851162](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566392851162-1566482453499.png)
2. ![1566392870314](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566392870314-1566482453499.png)
3. ![1566392878747](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566392878747-1566482453499.png)

### 2.2 应用优化

1. 容器优化:内置容器Tomcat与Undertow的比较与参数设置
2. 组件优化:内部集成的组件优化，如Hystrix线程隔离、Ribbon
3. JVM参数优化:适用于网关应用的JVM参数建议
4. 内部优化:

## 3.Gateway

1. 简介
   1. 提供简单、有效且统一的API路由管理方式
   2. 路由:路由是网关最基础的部分
   3. 断言:java8中的断言函数。
   4. 过滤器:一个标准的Spring webFilter。springcloudgateway中的filter分为两种Gateway Filter和Global Filter
2. 工作流程图
   1. ![1566393822831](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566393822831-1566482453499.png)

## 4.Ribbon

1. 定义

   1. 集中式负载均衡
   2. 进程式负载均衡:从实例库选取一个实例进行流量导入，客户端负载均衡
   3. ![1566473904315](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566473904315-1566482453499.png)

2. 负载均衡策略

   1. ![1566475901062](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566475901062-1566482453499.png)

   2. ![1566475912745](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566475912745-1566482453499.png)

   3. 饥饿加载

      1. ```yml
         ribbon:  
         	eager-load:    
         	enabled: true    
         	clients: client-a
         
         ```

   4. 利用配置文件自定义Ribbon

      1. ![1566476918325](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566476918325-1566482453499.png)

### 4.1 核心工作原理

1. ![1566476969959](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566476969959-1566482453499.png)

## 5.Hystrix

1. 定义
   1. ![1566477524140](C:\Users\zxw\Desktop\个人项目笔记\SpringCloud教程.assets\1566477524140.png)
   2. 通过客户端库对延迟和故障进行保护和控制
   3. 在一个复杂的分布式系统中停止级联故障
   4. 快速失败和迅速恢复
   5. 在合理的情况下回退和优雅地降级
   6. 开启近实时监控、告警和操作控制

## 6.Feign

1. 简介

   1. 声明式的Web Service客户端
   2. 声明式、模板化的HTTP客户端
   3. 可插拔的注解主持，包括Feign注解和JAX-RS注解
   4. 支持可插拔的HTTP编码器和解码器
   5. 支持Hystrix和它的Fallback
   6. 支持Ribbon的负载均衡
   7. 支持HTTP请求和响应的压缩,整合了Ribbon和Hystrix

2. 开启GZIP压缩

   1. ```yml
      feign:
      	compression:
      		request:
      			enable: true
      		mime-types: text/xml.application/xml,application/json #配置压缩支持的MIME TYPE
      		min-request-size: 2048 #配置压缩数据大小的下限
      		response:
      			enable: true # 配置响应GZIP压缩
      
      ```

      ![1566481604560](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566481604560-1566482453499.png)

3. 属性文件配置

   1. ![1566481624772](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566481624772-1566482453499.png)
   2. ![1566481650941](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566481650941-1566482453499.png)

4. 开启日志

   1. ![1566481699420](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566481699420-1566482453499.png)

5. 超时设置

   1. Feign的调用分两层，即Ribbono的调用和Hystrix的调用，高版本的Hystrix默认是关闭的![1566481748576](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566481748576-1566482453499.png)
   2. ![1566481762013](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566481762013-1566482453499.png)

### 6.1 Feign默认Client的替换

1. 默认使用URLConnection发送HTTP请求，没有连接池，但是对每一个地址会保持长连接
2. 使用httpClient替换
   1. 导入![1566481918333](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566481918333-1566482453499.png)
   2. ![1566481926090](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566481926090-1566482453499.png)
3. 使用okhttp替换
   1. ![1566481942427](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566481942427-1566482453500.png)
   2. ![1566481951817](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566481951817-1566482453500.png)
   3. ![1566481970679](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566481970679-1566482453500.png)

### 6.2 Feign的Post和Get的多参数传递

1. ![1566482085435](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566482085435-1566482453500.png)

### 6.3 文件上传

1. ![1566482112576](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566482112576-1566482453500.png)

### 6.4 首次请求失败问题

1. ![1566482163677](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566482163677-1566482453500.png)

### 6.5 返回图片流处理方式

1. ![1566482214765](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566482214765-1566482453500.png)

### 6.5 Feign调用传递Toekn

1. ![1566482231428](C:\Users\zxw\Desktop\个人项目笔记\SpringCloud教程.assets\1566482231428.png)
2. ![1566482241541](D:\code\IDEA CODE\springcloud-Learn\README.assets\1566482241541-1566482453500.png)

