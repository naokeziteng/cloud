package com.naokeziteng.cloud.service.impl;

import com.naokeziteng.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author aku
 * @Date 2020/11/19
 * @Description
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String payment_ok(Long id) {
        return "线程池:  "+Thread.currentThread().getName() + ",ok,哈哈哈...";
    }

    @Override
    @HystrixCommand(fallbackMethod = "payment_timeout_fallback_handle",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String payment_timeout(Long id) {
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        int i = 10 / 0;
        return "线程池:  "+Thread.currentThread().getName() + ",ok,哈哈哈..." + "等待3秒";
    }

    @Override
    @HystrixCommand(fallbackMethod = "payment_circuit_breaker_fallback_handle",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") //错误百分比
    })
    public String paymentCircuitBreaker(Long id) {
        if(id < 0) {
            throw new RuntimeException("参数错误");
        }
        return "流水号: "+UUID.randomUUID().toString();
    }

    public String payment_timeout_fallback_handle(Long id) {
        return "线程池:  "+Thread.currentThread().getName() + ",处理失败,服务降级...";
    }

    public String payment_circuit_breaker_fallback_handle(Long id) {
        return "请求失败,id 不能为负数...";
    }
}
