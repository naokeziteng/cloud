package com.naokeziteng.cloud.service.impl;

import com.naokeziteng.cloud.entity.PaymentEntity;
import com.naokeziteng.cloud.mapper.PaymentMapper;
import com.naokeziteng.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author aku
 * @Date 2020/11/13
 * @Description
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public void save(PaymentEntity payment) {
        if (paymentMapper.save(payment) != 1) {
            throw new RuntimeException("保存失败");
        }
    }

    @Override
    public PaymentEntity getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
