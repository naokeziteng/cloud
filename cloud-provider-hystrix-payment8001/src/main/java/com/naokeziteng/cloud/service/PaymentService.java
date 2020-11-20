package com.naokeziteng.cloud.service;

/**
 * @author aku
 * @Date 2020/11/19
 * @Description
 */
public interface PaymentService {
    /**
     * 正常请求
     *
     * @param id
     * @return
     */
    String payment_ok(Long id);


    /**
     * 超时请求
     *
     * @param id
     * @return
     */
    String payment_timeout(Long id);

    /**
     * 熔断测试
     * @param id
     * @return
     */
    String paymentCircuitBreaker(Long id);
}
