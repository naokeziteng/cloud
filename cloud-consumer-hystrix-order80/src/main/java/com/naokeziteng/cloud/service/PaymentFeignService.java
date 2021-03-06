package com.naokeziteng.cloud.service;

import com.naokeziteng.cloud.service.impl.PaymentFeignFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author aku
 * @Date 2020/11/19
 * @Description
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",fallback = PaymentFeignFallbackService.class)
public interface PaymentFeignService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String payment_ok(@PathVariable("id") Long id);


    @GetMapping("/payment/hystrix/timeout/{id}")
    String payment_timeout(@PathVariable("id") Long id);
}
