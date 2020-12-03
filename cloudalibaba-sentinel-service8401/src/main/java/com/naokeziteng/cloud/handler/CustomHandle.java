package com.naokeziteng.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author aku
 * @Date 2020/12/3
 * @Description
 */
public class CustomHandle {

    public static String ex1(BlockException e) {
        return "自定义异常处理: 1";
    }

    public static String ex2(BlockException e) {
        return "自定义异常处理: 2";
    }
}
