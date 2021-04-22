package com.hs.customerInfo.controller;

import com.hs.config.CommonResult;
import com.hs.customerInfo.service.CustomerInfoService;
import com.hs.entity.CustomerInfo;
import org.apache.dubbo.config.annotation.Reference;
import org.checkerframework.checker.units.qual.C;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Huasheng
 * @Date 2021/04/16/8:59
 * @Description
 */

@RestController
@RequestMapping("/CustomerInfo")
public class CustomerInfoController {

    @Resource
    private CustomerInfoService customerInfoService;

    @GetMapping("/addCustomerInfo")
    public void addCustomer(CustomerInfo customerInfo){
        customerInfoService.addCustomerInfo(customerInfo);
    }

    @GetMapping("/findAll")
    public CommonResult findAll(){
        return CommonResult.success(customerInfoService.findAll());
    }

    @GetMapping("/findAnd")
    public CommonResult findAnd(){
        return CommonResult.success(customerInfoService.findAnd());
    }
}
