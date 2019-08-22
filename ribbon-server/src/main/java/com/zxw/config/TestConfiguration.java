package com.zxw.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zxw
 * @date 2019/8/22 20:25
 */
@Configuration
public class TestConfiguration {
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
