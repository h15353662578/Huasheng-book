package com.hs.bookstock.service.impl;

import com.hs.bookstock.mapper.StockMapper;
import com.hs.bookstock.service.StockService;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.transaction.Propagation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author Huasheng
 * @Date 2021/04/19/14:16
 * @Description
 */

@Slf4j
@Service(timeout = 10000,group = "book-storage-service")
public class StockServiceImpl implements StockService{

    @Resource
    private StockMapper stockMapper;

    @Override
    @GlobalTransactional(name = "book-storage-service", rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public void decrease(Long productId, Integer count) {
        log.info("----> StorageService中扣减库存");
        stockMapper.decrease(productId, count);
        log.info("----> StorageService中扣减库存完成");
    }
}
