package com.hs.customerInfo.service;

import com.hs.entity.BookInfo;
import com.hs.entity.BookOrder;
import com.hs.entity.CustomerInfo;

import java.util.List;
import java.util.Map;

/**
 * @author Huasheng
 * @Date 2021/04/16/8:58
 * @Description
 */
public interface CustomerInfoService {

    public void addCustomerInfo(CustomerInfo customerInfo);

    public CustomerInfo findAll();

    public List<Map<BookInfo, BookOrder>> findAnd();
}
