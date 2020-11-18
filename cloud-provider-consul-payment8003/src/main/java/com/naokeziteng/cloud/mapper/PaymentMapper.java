package com.naokeziteng.cloud.mapper;

import com.naokeziteng.cloud.entity.PaymentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author aku
 * @Date 2020/11/13
 * @Description
 */
@Mapper
public interface PaymentMapper {
    /**
     * 新增
     *
     * @param payment
     * @return
     */
    int save(PaymentEntity payment);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    PaymentEntity getPaymentById(@Param("id") Long id);
}
