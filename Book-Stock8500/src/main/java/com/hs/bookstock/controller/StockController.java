package com.hs.bookstock.controller;

import com.hs.bookstock.service.StockService;
import com.hs.config.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Huasheng
 * @Date 2021/04/19/14:16
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("/BookStorage")
public class StockController {

    @Resource
    private StockService stockService;

    @GetMapping("/decrease")
    public CommonResult decrease(@RequestParam("bookId") Long bookId, @RequestParam("count") Integer count){
        stockService.decrease(bookId, count);
        log.info("扣减库存成功!");
        return CommonResult.success("200");
    }
}
