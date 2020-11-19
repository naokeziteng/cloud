package com.naokeziteng.cloud.controller;

import com.naokeziteng.cloud.service.PaymentFeignService;
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
}
