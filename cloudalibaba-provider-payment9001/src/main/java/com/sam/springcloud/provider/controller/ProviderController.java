package com.sam.springcloud.provider.controller;

import com.sam.springcloud.entity.CommonResult;
import com.sam.springcloud.entity.Payment;
import com.sam.springcloud.provider.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ProviderController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") int id) {

        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            log.info("Got result by id: " + id);
            return new CommonResult<>(200, "Success", serverPort, payment);
        }else{
            return new CommonResult<>(500, "Failed", serverPort, null);
        }
    }
}
