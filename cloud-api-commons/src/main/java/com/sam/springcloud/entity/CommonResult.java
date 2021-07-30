package com.sam.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> implements Serializable {

    private Integer code;
    private String message;
    private String port;
    private T data;

    public CommonResult(Integer code, String message, String port) {
        this(code, message, port, null);
    }

}
