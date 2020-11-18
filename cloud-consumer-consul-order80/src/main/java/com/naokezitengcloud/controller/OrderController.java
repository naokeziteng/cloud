package com.naokezitengcloud.controller;

import com.naokeziteng.cloud.common.CommonResult;
import com.naokeziteng.cloud.entity.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author aku
 * @Date 2020/11/13
 * @Description
 */
@RestController
@RequestMapping("consumer")
public class OrderController {
    /**private static final String PAYMENT_URL = "http://127.0.0.1:8001/payment";*/
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/payment";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/payment")
    public CommonResult<Void> addPayment(@RequestBody PaymentEntity payment) {
        return restTemplate.postForObject(PAYMENT_URL, payment, CommonResult.class);
    }

    @GetMapping("/payment/{id}")
    public CommonResult<PaymentEntity> findById(@PathVariable("id") Long id) {
        CommonResult<PaymentEntity> result = restTemplate.getForObject(PAYMENT_URL + "/" + id, CommonResult.class);
        return result;
    }
}
