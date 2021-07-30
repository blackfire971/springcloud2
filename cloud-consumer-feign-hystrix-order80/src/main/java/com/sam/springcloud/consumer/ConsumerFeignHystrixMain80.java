package com.sam.springcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumerFeignHystrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignHystrixMain80.class, args);
    }
}
