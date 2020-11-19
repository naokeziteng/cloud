package com.naokeziteng.cloud.controller;

import com.naokeziteng.cloud.common.CommonResult;
import com.naokeziteng.cloud.entity.PaymentEntity;
import com.naokeziteng.cloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aku
 * @Date 2020/11/13
 * @Description
 */
@RestController
@RequestMapping("consumer")
public class OrderController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/{id}")
    public CommonResult<PaymentEntity> findById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }
}
