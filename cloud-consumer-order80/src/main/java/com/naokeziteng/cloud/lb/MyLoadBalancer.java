package com.naokeziteng.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author aku
 * @Date 2020/11/18
 * @Description
 */
@Component
public class MyLoadBalancer implements ILoadBalancer {
    private static AtomicInteger count = new AtomicInteger(0);

    public final int getRequestCount() {
        int current = count.get();
        int next;
        do {
            next = current + 1;
        } while (!count.compareAndSet(current, next));
        return next;
    }

    @Override
    public ServiceInstance getInstance(List<ServiceInstance> instances) {
        int index = getRequestCount() % instances.size();
        return instances.get(index);
    }
}
