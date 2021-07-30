package com.sam.springcloud.order.feign;

import com.sam.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @GetMapping(value = "/storage/decrease/{commodityCode}/{count}")
    CommonResult decrease(@PathVariable("commodityCode") String commodityCode, @PathVariable("count") Integer count);


}
