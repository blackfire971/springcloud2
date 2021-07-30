package com.sam.springcloud.sentinel.service.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sam.springcloud.entity.CommonResult;

public class SentinelErrorHandler {

    public static CommonResult handleException(String id, BlockException blockException) {
        return new CommonResult(444, "fail 1", "23");
    }

    public static CommonResult handleException2(String id, BlockException blockException) {
        String msg = blockException.getRuleLimitApp();
        return new CommonResult(444, msg, "25");
    }
}
