package com.sam.springcloud.order.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    private Long id;
    private String userId;
    private String commodityCode;
    private Integer count;
    private Integer money;
}
