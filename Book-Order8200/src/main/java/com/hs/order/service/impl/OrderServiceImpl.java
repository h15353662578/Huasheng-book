package com.hs.order.service.impl;

import com.hs.bookstock.service.StockService;
import com.hs.customerAccount.service.CustomerAccountService;
import com.hs.entity.BookOrder;
import com.hs.entity.CustomerOrder;
import com.hs.order.mapper.OrderMapper;
import com.hs.order.service.OrderService;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.transaction.Propagation;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

/**
 * @author Huasheng
 * @Date 2021/04/19/11:48
 * @Description
 */
@Slf4j
@Service(timeout = 10000,group = "book-order-service")
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @DubboReference(group = "customer-account-service")
    CustomerAccountService customerAccountService;

    @DubboReference(group = "book-storage-service")
    StockService stockService;

    @Override
    @GlobalTransactional(name = "book-order-service", rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public void create(@RequestBody BookOrder bookOrder) {
        // 1 新建订单
        log.info("----->开始新建订单");
        orderMapper.create(bookOrder);

        // 2 扣减库存
        log.info("----->订单微服务开始调用库存,做扣减Count");
        stockService.decrease(bookOrder.getCustomerId(), bookOrder.getCount());
        log.info("----->订单微服务开始调用库存,做扣减End");

        // 3 扣减账户
        log.info("----->订单微服务开始调用账户,做扣减Money");
        customerAccountService.decrease(bookOrder.getCustomerId(), bookOrder.getMoney());
        log.info("----->订单微服务开始调用账户,做扣减End");

        // 4 修改订单状态,从0到1,1代表已完成
        log.info("----->修改订单状态开始");

        orderMapper.update(bookOrder.getCustomerId(), 0   );

        log.info("----->下订单结束");
    }


}
