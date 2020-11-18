package com.naokeziteng.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author aku
 * @Date 2020/11/18
 * @Description
 */
public interface ILoadBalancer {

    /**
     * 获取服务实例
     *
     * @param instances
     * @return
     */
    ServiceInstance getInstance(List<ServiceInstance> instances);
}
