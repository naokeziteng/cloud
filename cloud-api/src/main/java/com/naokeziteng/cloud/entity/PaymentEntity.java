package com.naokeziteng.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aku
 * @Date 2020/11/13
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity {
    private Long id;
    /**支付流水号*/
    private String serial;
}
