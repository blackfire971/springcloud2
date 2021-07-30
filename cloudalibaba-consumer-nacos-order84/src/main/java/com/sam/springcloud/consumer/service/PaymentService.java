package com.sam.springcloud.consumer.service;

import com.sam.springcloud.consumer.service.impl.PaymentFallbackService;
import com.sam.springcloud.entity.CommonResult;
import com.sam.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-service", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/paymentsql/{id}")
    CommonResult<Payment> payment(@PathVariable("id") Long id);

}
