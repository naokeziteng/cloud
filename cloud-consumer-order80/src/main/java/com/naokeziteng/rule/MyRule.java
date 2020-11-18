package com.naokeziteng.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author aku
 * @Date 2020/11/18
 * @Description
 */
@Configuration
public class MyRule {

    @Bean
    public IRule getLoadRule() {
        return new RandomRule();
    }
}
