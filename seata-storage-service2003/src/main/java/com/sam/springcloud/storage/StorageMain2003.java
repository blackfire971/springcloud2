package com.sam.springcloud.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan(value = "com.sam.springcloud.storage.dao")
public class StorageMain2003 {
    public static void main(String[] args) {
        SpringApplication.run(StorageMain2003.class, args);
    }
}
