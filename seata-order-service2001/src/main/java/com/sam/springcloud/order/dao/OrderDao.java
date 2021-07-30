package com.sam.springcloud.order.dao;

import com.sam.springcloud.order.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface OrderDao {

    void create(Order order);

}
