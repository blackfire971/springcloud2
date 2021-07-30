package com.sam.springcloud.consumer.controller;

import com.sam.springcloud.entity.CommonResult;
import com.sam.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Value("${service-url.nacos-provider-service}")
    private String serviceUrl;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") int id) {
        return restTemplate.getForObject(serviceUrl + "/payment/get/" + id, CommonResult.class);
    }
}
