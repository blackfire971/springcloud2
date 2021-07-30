package com.sam.springcloud.order.controller;

import com.sam.springcloud.entity.CommonResult;
import com.sam.springcloud.order.domain.Order;
import com.sam.springcloud.order.service.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

//    @Value("${server.port}")
//    String port;

    @Resource
    OrderService orderService;

    @GetMapping(value = "/order/create/{commodityCode}/{count}/{money}")
    public CommonResult create(@PathVariable("commodityCode") String commodityCode,
                               @PathVariable("count") int count,
                               @PathVariable("money") int money) {
        Order order = new Order();
        order.setCount(count);
        order.setCommodityCode(commodityCode);
        order.setMoney(money);
        order.setUserId("1");
        CommonResult commonResult = orderService.create(order);
        return commonResult;
    }
}
