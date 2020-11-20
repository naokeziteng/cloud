package com.naokeziteng.cloud.controller;

import com.naokeziteng.cloud.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aku
 * @Date 2020/11/19
 * @Description
 */
@RestController
@RequestMapping("order")
@DefaultProperties(defaultFallback = "global_fallback_handle")
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Long id) {
        return paymentFeignService.payment_ok(id);
    }


    @GetMapping("/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Long id) {
        return paymentFeignService.payment_timeout(id);
    }

    @GetMapping("/payment/hystrix/fb/timeout/{id}")
    @HystrixCommand(fallbackMethod = "payment_timeout_fallback_handle",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String payment_timeout02(@PathVariable("id") Long id) {
        int i = 10 / 0;
        return paymentFeignService.payment_timeout(id);
    }

    public String payment_timeout_fallback_handle(@PathVariable("id") Long id) {
        return "80服务端,"+Thread.currentThread().getName() + "，处理失败，服务降级了...";
    }

    public String global_fallback_handle(@PathVariable("id") Long id) {
        return "80服务端,全局统一服务降级处理,"+Thread.currentThread().getName();
    }
}
