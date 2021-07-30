package com.sam.springcloud.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ProviderController {

    @Value("${server.port}")
    String port;

    @GetMapping(value = "/payment/zk")
    public String paymentZk(){
        return "zk: " + port + ", UUID: " + UUID.randomUUID().toString();
    }
}
