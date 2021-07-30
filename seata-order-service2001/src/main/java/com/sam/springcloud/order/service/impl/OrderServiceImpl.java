package com.sam.springcloud.order.service.impl;

import com.sam.springcloud.entity.CommonResult;
import com.sam.springcloud.order.dao.OrderDao;
import com.sam.springcloud.order.domain.Order;
import com.sam.springcloud.order.service.OrderService;
import com.sam.springcloud.order.feign.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {


    @Resource
    StorageService storageService;

    @Resource
    OrderDao orderDao;

    @Override
    @GlobalTransactional(name = "test_group", rollbackFor = Exception.class)
    public CommonResult create(Order order) {
        log.info("Start create order...");
        orderDao.create(order);
        log.info("Order created, start to deduct storge...");
        CommonResult commonResult = storageService.decrease(order.getCommodityCode(), order.getCount());
        log.info("Reduced storge count successful...");
        return commonResult;
    }
}
