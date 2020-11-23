package com.naokeziteng.cloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * @author aku
 * @Date 2020/11/23
 * @Description
 */
@Slf4j
@Component
public class MyLogGatewayFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*******come in MyLogGatewayFilter: " + LocalDateTime.now());
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (username == null) {
            log.info("*****用户名为空，非法用户.....");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }


    /**
     * 执行顺序
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
