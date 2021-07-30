package com.sam.springcloud.order.service;

import com.sam.springcloud.entity.CommonResult;
import com.sam.springcloud.order.domain.Order;

public interface OrderService {

    CommonResult create(Order order);

}
