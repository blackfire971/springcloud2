package com.sam.springcloud.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ClientConfigController {

    @Value("${config.info}")
    String info;

    @GetMapping("/config/info")
    public String info() {
        return info;
    }
}
