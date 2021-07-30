package com.sam.springcloud.consumer.service;

import com.sam.springcloud.entity.CommonResult;
import com.sam.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CLOUD-PROVIDER-SERVICE")
@Service
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}") //Need to be same with the path in provider controller
    CommonResult<Payment> getPaymentById(@PathVariable("id") int id);
}
