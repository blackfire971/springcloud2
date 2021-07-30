package com.sam.springcloud.provider.controller;

import com.sam.springcloud.entity.CommonResult;
import com.sam.springcloud.entity.Payment;
import com.sam.springcloud.provider.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Log4j2
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") int id) {

        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            log.info("Got result by id: " + id);
            return new CommonResult<>(200, "Success", serverPort, payment);
        }else{
            return new CommonResult<>(500, "Failed", serverPort, null);
        }
    }

    @GetMapping(value = "/payment/discover")
    public Object discoverClient() {
        List<String> services = discoveryClient.getServices();
        for (int i = 0; i < services.size(); i++) {
            log.info("service id: "+services.get(i));
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        for (int i = 0; i < instances.size(); i++) {
            log.info("instance id: "+instances.get(i));
        }
        return discoveryClient;
    }
}
