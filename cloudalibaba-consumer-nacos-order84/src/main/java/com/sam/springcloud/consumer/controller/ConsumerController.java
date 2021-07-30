package com.sam.springcloud.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.sam.springcloud.consumer.service.PaymentService;
import com.sam.springcloud.entity.CommonResult;
import com.sam.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    public static final String service_url = "http://nacos-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    PaymentService paymentService;

    @GetMapping(value = "/consumer/fallback/{id}")
    // defaul fallback by Sentinel
    // @SentinelResource(value = "fallback")
    // handle fallback with method, and only in charge of business exception
    @SentinelResource(value = "fallback", fallback = "handleFallback")
    //handle block when set limit in Sentinel
//    @SentinelResource(value = "fallback", blockHandler = "handleBlock")
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult<Payment> commonResult = restTemplate.getForObject(service_url + "/paymentsql/" + id, CommonResult.class);
//        CommonResult<Payment> commonResult = paymentService.payment(id);
        if (id > 3) {
            throw new IllegalArgumentException("IllegalArgumentException for id: " + id);
        } else if (commonResult.getData() == null) {
            throw new NullPointerException("NullPointerException for id: " + id);
        }
        return commonResult;
    }

    public CommonResult<Payment> handleFallback(Long id, Throwable e) {
        Payment payment = new Payment(0, null);
        return new CommonResult<>(444, "handleFallback: handing by fallback method"+e.getMessage(), "84", payment);
    }

    @GetMapping(value = "/consumer/openfeign/{id}")
    public CommonResult<Payment> openFeign(@PathVariable("id") Long id) {
        CommonResult<Payment> commonResult = paymentService.payment(id);
        if (id > 3) {
            throw new IllegalArgumentException("IllegalArgumentException for id: " + id);
        } else if (commonResult.getData() == null) {
            throw new NullPointerException("NullPointerException for id: " + id);
        }
        return commonResult;
    }
}
