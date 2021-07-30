package com.sam.springcloud.consumer.controller;

import com.sam.springcloud.consumer.service.ProviderFeignService;
import com.sam.springcloud.entity.CommonResult;
import com.sam.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource
    private ProviderFeignService providerFeignService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") int id) {
        String result = providerFeignService.paymentInfo_Ok(id);
        return new CommonResult<Payment>(200, "Success", result);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public CommonResult<Payment> paymentInfo_Timeout(@PathVariable("id") int id) {
        String result = providerFeignService.paymentInfo_Timeout(id);
        return new CommonResult<Payment>(200, "Timeout", result);
    }
}
