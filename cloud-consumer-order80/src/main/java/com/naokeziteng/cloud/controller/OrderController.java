package com.naokeziteng.cloud.controller;

import com.naokeziteng.cloud.common.CommonResult;
import com.naokeziteng.cloud.entity.PaymentEntity;
import com.naokeziteng.cloud.lb.ILoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author aku
 * @Date 2020/11/13
 * @Description
 */
@RestController
@RequestMapping("consumer")
public class OrderController {
    /**
     * private static final String PAYMENT_URL = "http://127.0.0.1:8001/payment";
     */
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/payment";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private ILoadBalancer iLoadBalancer;

    @PostMapping("/payment")
    public CommonResult<Void> addPayment(@RequestBody PaymentEntity payment) {
        return restTemplate.postForObject(PAYMENT_URL, payment, CommonResult.class);
    }

    @GetMapping("/payment/{id}")
    public CommonResult<PaymentEntity> findById(@PathVariable("id") Long id) {
        CommonResult<PaymentEntity> result = restTemplate.getForObject(PAYMENT_URL + "/" + id, CommonResult.class);
        return result;
    }

    @GetMapping("/customlb/payment/{id}")
    public CommonResult<PaymentEntity> findByIdCustomlb(@PathVariable("id") Long id) {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = iLoadBalancer.getInstance(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/payment/" + id, CommonResult.class);
    }

    @GetMapping("/payment/sleuth")
    public String sleuth() {
        String result = restTemplate.getForObject("http://localhost:8001/payment/sleuth", String.class);
        return result;
    }
}
