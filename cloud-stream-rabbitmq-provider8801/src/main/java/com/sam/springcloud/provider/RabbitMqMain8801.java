package com.sam.springcloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RabbitMqMain8801 {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqMain8801.class, args);
    }
}
