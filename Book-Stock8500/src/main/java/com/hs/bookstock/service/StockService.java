package com.hs.bookstock.service;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Huasheng
 * @Date 2021/04/19/14:16
 * @Description
 */
public interface StockService {


    void decrease(@RequestParam("bookId") Long bookId, @RequestParam("count") Integer count);

}
