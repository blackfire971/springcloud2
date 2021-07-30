package com.sam.springcloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class ProviderHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrixMain8001.class, args);
    }
}