package com.sam.springcloud.provider.controller;

import com.sam.springcloud.provider.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RabbitMqProviderController {

    @Resource
    IMessageProvider messageProvider;

    @GetMapping(value = "/sendMsg")
    public String sendMessage() {
        return messageProvider.send();
    }

}
