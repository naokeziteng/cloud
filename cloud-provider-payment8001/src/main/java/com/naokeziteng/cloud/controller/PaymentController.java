package com.naokeziteng.cloud.controller;

import com.naokeziteng.cloud.common.CommonResult;
import com.naokeziteng.cloud.entity.PaymentEntity;
import com.naokeziteng.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author aku
 * @Date 2020/11/13
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping
    public CommonResult<Void> addPayment(@RequestBody PaymentEntity payment) {
        paymentService.save(payment);
        log.info("请求成功" + serverPort);
        return CommonResult.success();
    }

    @GetMapping("{id}")
    public CommonResult<PaymentEntity> findById(@PathVariable("id") Long id) {
        log.info("请求成功" + serverPort);
        return CommonResult.success(paymentService.getPaymentById(id));
    }

    @GetMapping("/sleuth")
    public String sleuth() {
        return "sleuth链路测试...";
    }
}
