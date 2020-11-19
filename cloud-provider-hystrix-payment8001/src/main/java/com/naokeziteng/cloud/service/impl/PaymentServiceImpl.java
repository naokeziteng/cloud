package com.naokeziteng.cloud.service.impl;

import com.naokeziteng.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * @author aku
 * @Date 2020/11/19
 * @Description
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String payment_ok(Long id) {
        return Thread.currentThread().getName() + ",ok,哈哈哈...";
    }

    @Override
    public String payment_timeout(Long id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + ",ok,哈哈哈..." + "等待3秒";
    }
}
