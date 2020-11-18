package com.naokeziteng.cloud.service;

import com.naokeziteng.cloud.entity.PaymentEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author aku
 * @Date 2020/11/13
 * @Description
 */
public interface PaymentService {
    /**
     * 新增
     *
     * @param payment
     * @return
     */
    void save(PaymentEntity payment);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    PaymentEntity getPaymentById(@Param("id") Long id);
}
