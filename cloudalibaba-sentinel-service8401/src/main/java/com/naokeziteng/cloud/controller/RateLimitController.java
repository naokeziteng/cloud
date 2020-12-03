package com.naokeziteng.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.naokeziteng.cloud.handler.CustomHandle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aku
 * @Date 2020/12/3
 * @Description
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public String byResource() {
        return "按资源名称限流测试 OK";
    }

    public String handleException(BlockException e) {
        return e.getClass().getCanonicalName() + "\t 服务不可用";
    }

    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl", blockHandlerClass = CustomHandle.class, blockHandler = "ex1")
    public String byUrl() {
        return "按URL名称限流测试 OK";
    }
}
