package com.hs.order.controller;

import com.hs.config.CommonResult;
import com.hs.entity.BookOrder;
import com.hs.entity.CustomerOrder;
import com.hs.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Huasheng
 * @Date 2021/04/19/11:49
 * @Description
 */
@Slf4j
@RequestMapping("/BookOrder")
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     * http://localhost:5000/BookOrder/create?customerId=用户ID&bookId=商品ID&count=消费件数&money=花费余额
     * @param bookOrder
     * @return
     */
    @GetMapping("/create")
    public CommonResult create(BookOrder bookOrder) {
        orderService.create(bookOrder);
        return CommonResult.success("200");
    }
}
