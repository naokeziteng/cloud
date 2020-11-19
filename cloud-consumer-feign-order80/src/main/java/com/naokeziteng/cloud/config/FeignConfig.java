package com.naokeziteng.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author aku
 * @Date 2020/11/19
 * @Description
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLogLevel() {
        return Logger.Level.FULL;
    }
}
