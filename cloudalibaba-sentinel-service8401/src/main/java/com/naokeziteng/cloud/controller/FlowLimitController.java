package com.naokeziteng.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/testD")
    public String testD() {
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        int i = 1 / 0;
        return "------------testD";
    }

    @GetMapping("/testHotkey")
    @SentinelResource(value = "testHotkey", blockHandler = "testHotkey_fallback")
    public String testHotkey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p1", required = false) String p2) {
        return "testHotkey";
    }

    public String testHotkey_fallback(String p1, String p2, BlockException exception) {
        return "testHotkey_fallback";
    }
}
