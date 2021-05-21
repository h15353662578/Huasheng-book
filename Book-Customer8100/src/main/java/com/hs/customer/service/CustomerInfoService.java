package com.hs.customer.service;

import com.hs.entity.BookInfo;
import com.hs.entity.BookOrder;
import com.hs.entity.CustomerInfo;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;
import java.util.Map;

/**
 * @author Huasheng
 * @Date 2021/05/21/9:19
 * @Description
 */
@FeignClient("customer-info-service")
public interface CustomerInfoService {

    public void addCustomerInfo(CustomerInfo customerInfo);

    public List<CustomerInfo> findAll();

    public List<Map<BookInfo, BookOrder>> findAnd();
}
