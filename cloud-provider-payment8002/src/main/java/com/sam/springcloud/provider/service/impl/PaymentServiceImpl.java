package com.sam.springcloud.provider.service.impl;

import com.sam.springcloud.entity.Payment;
import com.sam.springcloud.provider.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public Payment getPaymentById(int id) {

        Payment payment = new Payment();
        if (id != 999) {
            payment.setId(id);
            payment.setSerial(id + "-abdkciq112dfad");
        }else{
            payment = null;
        }
        return payment;
    }
}
