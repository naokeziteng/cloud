package com.naokeziteng.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author aku
 * @Date 2020/11/23
 * @Description
 */
@Configuration
public class GatewayConfig {


    @Bean
    public RouteLocator customLocator(RouteLocatorBuilder locatorBuilder) {
        RouteLocatorBuilder.Builder routes = locatorBuilder.routes();
        routes.route("path_route_baidu",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
