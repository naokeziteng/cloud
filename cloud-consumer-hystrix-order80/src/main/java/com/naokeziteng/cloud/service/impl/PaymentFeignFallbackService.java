package com.naokeziteng.cloud.service.impl;

import com.naokeziteng.cloud.service.PaymentFeignService;
import org.springframework.stereotype.Service;

/**
 * @author aku
 * @Date 2020/11/20
 * @Description
 */
@Service
public class PaymentFeignFallbackService implements PaymentFeignService {
    @Override
    public String payment_ok(Long id) {
        return "服务降级了......";
    }

    @Override
    public String payment_timeout(Long id) {
        return "服务降级了......";
    }
}
