package com.sam.springcloud.service.controller;

import com.sam.springcloud.entity.CommonResult;
import com.sam.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

@RestController
public class ProviderController {

    @Value("${server.port}")
    private String port;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1, UUID.randomUUID().toString()));
        hashMap.put(2L, new Payment(2, UUID.randomUUID().toString()));
        hashMap.put(3L, new Payment(3, UUID.randomUUID().toString()));
    }

    @GetMapping(value = "/paymentsql/{id}")
    public CommonResult<Payment> payment(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> commonResult = new CommonResult<>(200, "from mysql", port, payment);
        return commonResult;
    }
}
