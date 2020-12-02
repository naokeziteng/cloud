package com.naokeziteng.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aku
 * @Date 2020/12/2
 * @Description
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "------------testA";
    }


    @GetMapping("/testB")
    public String testB() {
        return "------------testB";
    }
}
