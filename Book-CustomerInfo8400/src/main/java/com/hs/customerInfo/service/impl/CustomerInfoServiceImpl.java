package com.hs.customerInfo.service.impl;

import com.hs.customerInfo.mapper.CustomerInfoMapper;
import com.hs.customerInfo.service.CustomerInfoService;
import com.hs.entity.BookInfo;
import com.hs.entity.BookOrder;
import com.hs.entity.CustomerInfo;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author Huasheng
 * @Date 2021/04/16/8:58
 * @Description
 */

@Service(timeout = 10000,group = "customer-info-service")
public class CustomerInfoServiceImpl implements CustomerInfoService {

    @Resource
    private CustomerInfoMapper customerInfoMapper;

    @Override
    @GlobalTransactional(name = "customer-info-service",rollbackFor = Exception.class)
    public void addCustomerInfo(CustomerInfo customerInfo){
        customerInfo.setCreateDate(new Date());
        customerInfoMapper.addCustomerInfo(customerInfo);
    }

    @Override
    public CustomerInfo findAll(){
        return customerInfoMapper.findAll();
    }

    @Override
    public List<Map<BookInfo, BookOrder>> findAnd(){
        return customerInfoMapper.findAnd();
    }
}
