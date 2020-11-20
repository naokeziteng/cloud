package com.naokeziteng.cloud.controller;

import com.naokeziteng.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;


    @GetMapping("/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Long id) {
        return paymentService.payment_ok(id);
    }


    @GetMapping("/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Long id) {
        return paymentService.payment_timeout(id);
    }

    @GetMapping("/hystrix/circuit_breaker/{id}")
    public String payment_circuit_breaker(@PathVariable("id") Long id) {
        return paymentService.paymentCircuitBreaker(id);
    }
}
