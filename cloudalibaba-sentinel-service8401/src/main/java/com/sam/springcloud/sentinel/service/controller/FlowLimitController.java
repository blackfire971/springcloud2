package com.sam.springcloud.sentinel.service.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sam.springcloud.entity.CommonResult;
import com.sam.springcloud.sentinel.service.handler.SentinelErrorHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {
    @GetMapping(value = "/checkinfo/a")
    public String testA() {
        return "testA";
    }

    @GetMapping(value = "/checkinfo/b")
    public String testB() {
        return "testB";
    }

    @GetMapping(value = "/checkinfo/d/{id}")
    @SentinelResource(value = "testD", blockHandler = "testD_handler")
    public String testD(@PathVariable("id") String id) {
        return "testD";
    }

    public String testD_handler(String id, BlockException blockException) {
        return "testD_handler...";
    }

    @GetMapping(value = "/checkinfo/e/{id}")
    @SentinelResource(value = "testE",
            blockHandlerClass = {SentinelErrorHandler.class},
            blockHandler = "handleException2")
    public CommonResult testE(@PathVariable("id") String id) {
        return new CommonResult(200, "success", "26");
    }
}
