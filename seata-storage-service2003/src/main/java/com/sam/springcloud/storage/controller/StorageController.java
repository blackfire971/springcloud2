package com.sam.springcloud.storage.controller;

import com.sam.springcloud.entity.CommonResult;
import com.sam.springcloud.storage.dao.StorageDao;
import com.sam.springcloud.storage.domain.Storage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StorageController {

    @Value("${server.port}")
    String port;

    @Resource
    StorageDao storageDao;

    @GetMapping(value = "/storage/create/{commodityCode}/{count}")
    public CommonResult createStorage(@PathVariable("commodityCode") String commodityCode, @PathVariable("count") int count) {
        Storage storage = new Storage();
        storage.setCount(count);
        storage.setCommodityCode(commodityCode);
        storageDao.create(storage);
        return new CommonResult(200, "Create Storage Successfully...", port);
    }

    @GetMapping(value = "/storage/decrease/{commodityCode}/{count}")
    public CommonResult decrease(@PathVariable("commodityCode") String commodityCode, @PathVariable("count") Integer count){
        Storage storage = new Storage();
        storage.setCount(count);
        storage.setCommodityCode(commodityCode);
        storageDao.decrease(storage);
        return new CommonResult(200, "Create Storage Successfully...", port);
    }
}
