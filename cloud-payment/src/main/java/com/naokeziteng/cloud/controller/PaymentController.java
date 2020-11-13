package com.naokeziteng.cloud.controller;

import com.naokeziteng.cloud.common.CommonResult;
import com.naokeziteng.cloud.entity.PaymentEntity;
import com.naokeziteng.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author aku
 * @Date 2020/11/13
 * @Description
 */
@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public CommonResult<Void> addPayment(@RequestBody PaymentEntity payment) {
        paymentService.save(payment);
        return CommonResult.success();
    }

    @GetMapping("{id}")
    public CommonResult<PaymentEntity> findById(@PathVariable("id") Long id) {
        return CommonResult.success(paymentService.getPaymentById(id));
    }
}
