package com.sam.springcloud.storage.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data()
public class Storage {

    private Long id;
    private String commodityCode;
    private Integer count;
}
