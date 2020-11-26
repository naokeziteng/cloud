package com.naokeziteng.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author aku
 * @Date 2020/11/26
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentProviderApplication.class, args);
    }
}
