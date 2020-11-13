package com.naokeziteng.cloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aku
 * @Date 2020/11/13
 * @Description 同一返回结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    /**
     * 返回数据
     */
    private T data;

    public static CommonResult success(Object data) {
        return new CommonResult(200, "success", data);
    }

    public static CommonResult success() {
        return new CommonResult(200, "success", null);
    }
}
