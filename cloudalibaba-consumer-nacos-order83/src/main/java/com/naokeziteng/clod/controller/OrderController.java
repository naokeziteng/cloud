package com.naokeziteng.clod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author aku
 * @Date 2020/11/26
 * @Description
 */
@RestController
public class OrderController {
    @Value("${service-url.nacos-user-service}")
    private String paymentURL;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order/payment/{id}")
    public String getPayment(@PathVariable("id") String id) {
        String result = restTemplate.getForObject(paymentURL + "/payment/nacos/" + id, String.class);
        return result;
    }
}
