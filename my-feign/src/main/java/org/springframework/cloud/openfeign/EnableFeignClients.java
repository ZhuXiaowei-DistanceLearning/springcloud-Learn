package org.springframework.cloud.openfeign;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({FeignClientsRegistrar.class})
/**
 * 注入FeignClientsRegistrar
 * 扫描FeignClient的包信息
 * 指定FeignClient接口类的自定义配置类
 */
public @interface EnableFeignClients {
    String[] basePackages() default {};

    Class<?>[] basePackagesClasses() default {};

    Class<?>[] defaultConfiguration() default {};

    // 指定被注解修饰的类，如果不为空，那么路径自动检测机制会被关闭
    Class<?>[] clients() default {};
}
