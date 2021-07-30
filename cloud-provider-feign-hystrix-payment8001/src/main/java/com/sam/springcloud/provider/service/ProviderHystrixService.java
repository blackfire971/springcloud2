package com.sam.springcloud.provider.service;

import cn.hutool.core.thread.ThreadUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;


@Service
@DefaultProperties(defaultFallback = "globalFallback")
public class ProviderHystrixService {

    public String paymentInfo_Ok(Integer id) {
        return "Thread Name: " + Thread.currentThread().getName() + ", paymentInfo_Ok: " + id + ", Works";
    }

    public String globalFallback() {
        return "Thread Name: " + Thread.currentThread().getName() + ", globalFallback: " + ", Global Fallback";
    }

    public String fallbackForTimeoutMethod(Integer id) {
        return "Thread Name: " + Thread.currentThread().getName() + ", fallbackForTimeoutMethod: " + id + ", Timeout";
    }

    @HystrixCommand
//    @HystrixCommand(fallbackMethod = "fallbackForTimeoutMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })
    public String paymentInfo_Timeout(Integer id) {

        try {
            ThreadUtil.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Thread Name: " + Thread.currentThread().getName() + ", paymentInfo_Timeout: " + id + ", Timeout";
    }

    // circuit break
//    @HystrixCommand(fallbackMethod = "fallbackForTimeoutMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })
    @HystrixCommand(fallbackMethod = "fallbackForCircuitBreak", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public String paymentCircuitBreak(Integer id) {

        if (id < 0) {
            throw new RuntimeException("id cannot be negative..");
        }
        return "Thread Name: " + Thread.currentThread().getName() + ", paymentCircuitBreak: " + id + ", Success";
    }

    public String fallbackForCircuitBreak(Integer id) {
        return "Thread Name: " + Thread.currentThread().getName() + ", fallbackForTimeoutMethod: " + id + ", Timeout";
    }

}
