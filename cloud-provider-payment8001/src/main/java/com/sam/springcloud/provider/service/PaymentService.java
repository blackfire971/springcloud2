package com.sam.springcloud.provider.service;


import com.sam.springcloud.entity.Payment;

public interface PaymentService {

    Payment getPaymentById(int id);
}
