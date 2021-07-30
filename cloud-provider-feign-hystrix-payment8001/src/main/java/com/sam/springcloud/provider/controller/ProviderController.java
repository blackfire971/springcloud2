package com.sam.springcloud.provider.controller;

import com.sam.springcloud.provider.service.ProviderHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProviderController {

    @Resource
    private ProviderHystrixService providerHystrixService;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id) {
        String result = providerHystrixService.paymentInfo_Ok(id);
        return result;
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        String result = providerHystrixService.paymentInfo_Timeout(id);
        return result;
    }

    @GetMapping(value = "/payment/hystrix/circuit/{id}")
    public String paymentInfo_Circuit(@PathVariable("id") Integer id) {
        String result = providerHystrixService.paymentCircuitBreak(id);
        return result;
    }
}
