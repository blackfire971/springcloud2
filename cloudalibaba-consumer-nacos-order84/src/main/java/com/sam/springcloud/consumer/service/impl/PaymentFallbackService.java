package com.sam.springcloud.consumer.service.impl;

import com.sam.springcloud.consumer.service.PaymentService;
import com.sam.springcloud.entity.CommonResult;
import com.sam.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> payment(Long id) {
        Payment payment = new Payment(0, null);
        return new CommonResult<>(444, "Failed: Feign", "84", payment);
    }

}
