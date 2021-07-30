package com.sam.springcloud.consumer.controller;

import com.sam.springcloud.consumer.service.PaymentFeignService;
import com.sam.springcloud.entity.CommonResult;
import com.sam.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerFeignController {

//    private static final String PAYMENT_URL ="http://localhost:8001";
    private static final String PAYMENT_URL ="http://CLOUD-PROVIDER-SERVICE";

    @Resource
    PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") int id) {
        return paymentFeignService.getPaymentById(id);
    }


}
