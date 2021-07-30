package com.sam.springcloud.storage.dao;

import com.sam.springcloud.storage.domain.Storage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StorageDao {

    void create(Storage storage);

    void decrease(Storage storage);
}
