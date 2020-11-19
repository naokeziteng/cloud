package com.naokeziteng.cloud.service;

import com.naokeziteng.cloud.common.CommonResult;
import com.naokeziteng.cloud.entity.PaymentEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author aku
 * @Date 2020/11/19
 * @Description
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/{id}")
    CommonResult<PaymentEntity> getPaymentById(@PathVariable("id") Long id);
}
