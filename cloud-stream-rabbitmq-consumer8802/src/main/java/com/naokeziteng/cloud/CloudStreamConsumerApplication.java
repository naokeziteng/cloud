package com.naokeziteng.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author aku
 * @Date 2020/11/25
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudStreamConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamConsumerApplication.class, args);
    }
}
